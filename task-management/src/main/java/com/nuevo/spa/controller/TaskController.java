package com.nuevo.spa.controller;

import com.nuevo.spa.model.TaskResponse;
import com.nuevo.spa.model.TaskRequest;
import com.nuevo.spa.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@RequiredArgsConstructor
@Tag(name = "Tareas", description = "Operaciones relacionadas con tareas de los usuarios")
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "Obtener todas las tareas del usuario autenticado")
    @ApiResponse(responseCode = "200", description = "Lista de tareas obtenida correctamente")
    @GetMapping
    public List<TaskResponse> getAll(Authentication auth) {
        return taskService.getAll(auth.getName());
    }


    @Operation(summary = "Obtener una tarea por su ID")
    @ApiResponse(responseCode = "200", description = "Tarea obtenida correctamente")
    @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> byId(@PathVariable Long id, Authentication auth) {
        return new ResponseEntity<>(taskService.getById(id, auth.getName()), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva tarea")
    @ApiResponse(responseCode = "201", description = "Tarea creada exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos")
    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody  @Valid TaskRequest dto, Authentication auth) {
        return new  ResponseEntity<>(taskService.create(dto, auth.getName()), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar una tarea existente")
    @ApiResponse(responseCode = "200", description = "Tarea actualizada correctamente")
    @ApiResponse(responseCode = "404", description = "Tarea no encontrada")
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> update(@PathVariable Long id, @RequestBody @Valid TaskRequest dto, Authentication auth) {
        return new ResponseEntity<>(taskService.update(id, dto, auth.getName()), HttpStatus.OK);
    }

    @Operation(summary = "Eliminar una tarea")
    @ApiResponse(responseCode = "200", description = "Tarea eliminada exitosamente")
    @ApiResponse(responseCode = "404", description = "Tarea no encontrada")

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id, Authentication auth) {
        taskService.delete(id, auth.getName());
        return ResponseEntity.ok("Tarea eliminada exitosamente");
    }

}
