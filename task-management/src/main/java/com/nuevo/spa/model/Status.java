package com.nuevo.spa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "Status",
        title = "Estado de una tarea",
        description = "Representa el estado o estatus de una tarea"
)
public record Status(
        @Schema(description = "Identificador único del estado", example = "1")
        @JsonProperty("id") long id,
        @Schema(description = "Nombre del estado", example = "COMPLETADA")
        @JsonProperty("estatus") String name,
        @Schema(description = "Descripción del estado", example = "El usuario se encuentra activo en el sistema.")
        @JsonProperty("descripción") String description) {
}
