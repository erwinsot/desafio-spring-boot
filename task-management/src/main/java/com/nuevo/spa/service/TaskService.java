package com.nuevo.spa.service;

import com.nuevo.spa.model.TaskResponse;
import com.nuevo.spa.model.TaskRequest;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAll(String name);
    TaskResponse create(TaskRequest dto, String username);
    TaskResponse update(Long id, TaskRequest dto, String username);
    void delete(Long id, String username);
    TaskResponse getById(Long id, String username);
}
