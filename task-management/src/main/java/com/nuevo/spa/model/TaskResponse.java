package com.nuevo.spa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(
        name = "TaskResponse",
        title = "Respuesta de Tarea",
        description = "Objeto que representa los datos completos de una tarea"
)
public record TaskResponse(
        @Schema(description = "Identificador único de la tarea", example = "101")
        @JsonProperty("id") Long id,
        @Schema(description = "Título de la tarea", example = "Revisar reporte financiero")
        @JsonProperty("titulo") String title,
        @Schema(description = "Descripción de la tarea", example = "Verificar cifras del Q2 antes de enviarlas")
        @JsonProperty("descripción") String description,
        @Schema(description = "Estado actual de la tarea")
        @JsonProperty("estado") Status status,
        @Schema(description = "Usuario asignado a la tarea")
        @JsonProperty("usuario") UserDto user)
{
}
