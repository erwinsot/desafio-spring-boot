package com.nuevo.spa.service;

import com.nuevo.spa.entity.StatusTask;
import com.nuevo.spa.entity.Task;
import com.nuevo.spa.entity.User;
import com.nuevo.spa.error.StatusNotFoundException;
import com.nuevo.spa.error.TaskNotFoundException;
import com.nuevo.spa.model.Status;
import com.nuevo.spa.model.TaskResponse;
import com.nuevo.spa.model.TaskRequest;
import com.nuevo.spa.model.UserDto;
import com.nuevo.spa.repository.StatusTaskRepository;
import com.nuevo.spa.repository.TaskRepository;
import com.nuevo.spa.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;



@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final StatusTaskRepository statusTaskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, StatusTaskRepository statusTaskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.statusTaskRepository = statusTaskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<TaskResponse> getAll(String name) {
        return taskRepository.findByUser_username(name).stream()
                .map(this::mapToDto)
                .toList();
    }


    @Override
    public TaskResponse create(TaskRequest dto, String username) {
        User u = userRepository.findByUsername(username).orElseThrow();
        StatusTask e = statusTaskRepository.findById(dto.statusId()).orElseThrow(()-> new StatusNotFoundException("Estado con ID " + dto.statusId() + " no encontrado: " + "Permitidas: id:1-->PENDIENTE, id:2-->EN_PROCESO, id:3-->COMPLETADA, id:4-->CANCELADA"));
        Task t = new Task(null, dto.title(), dto.description(),  u, e, LocalDateTime.now(), LocalDateTime.now());
        return mapToDto(taskRepository.save(t));
    }

    @Override
    public TaskResponse update(Long id, TaskRequest dto, String username) {
        Task t = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarea con ID " + id + " no encontrada"));
        findOutUser(t, username);
        t.setTitle(dto.title());
        t.setDescription(dto.description());
        t.setStatus(statusTaskRepository.findById(dto.statusId()).orElseThrow());
        return mapToDto(taskRepository.save(t));
    }

    @Override
    public void delete(Long id, String username) {
        Task t = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarea con ID " + id + " no encontrada"));
        findOutUser(t, username);
        taskRepository.delete(t);
    }

    @Override
    public TaskResponse getById(Long id, String username) {
        Task t = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarea con ID " + id + " no encontrada"));
        findOutUser(t, username);
        return mapToDto(t);
    }

    private void findOutUser(Task t, String username) {
        if (!t.getUser().getUsername().equals(username)) {
            throw new SecurityException("No autorizado");
        }
    }

    private TaskResponse mapToDto(Task t) {
        Status status = new Status(t.getStatus().getId(), t.getStatus().getName(), t.getStatus().getDescription());
        UserDto userDto = new UserDto(t.getUser().getId(), t.getUser().getUsername(), t.getUser().getNombre());
        return new TaskResponse(t.getId(), t.getTitle(), t.getDescription(), status, userDto);
    }
}
