package com.nuevo.spa.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(
        name = "TaskRequest",
        title = "Solicitud de Tarea",
        description = "Contiene los datos requeridos para crear o actualizar una tarea"
)
public record TaskRequest(
        @Schema(description = "Título de la tarea", example = "Enviar informe mensual")
        @NotBlank(message = "El título es obligatorio") String title,
        @Schema(description = "Descripción detallada de la tarea", example = "Enviar el informe mensual al cliente")
        @NotBlank(message = "La descripción es obligatoria")  String description,
        @Schema(description = "Identificador del estado asociado a la tarea", example = "2")
        @NotNull(message = "El id del estado es obligatorio") long statusId
) {}
