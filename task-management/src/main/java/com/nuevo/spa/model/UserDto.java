package com.nuevo.spa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


@Schema(
        name = "UserDto",
        title = "Información del Usuario",
        description = "Contiene los datos públicos del usuario que creó la tarea"
)
public record UserDto(
        @Schema(description = "Identificador único del usuario", example = "42")
        @JsonProperty("id") long id,
        @Schema(description = "Nombre de usuario", example = "jdoe")
        @JsonProperty("usuario") String username,
        @Schema(description = "Nombre completo del usuario", example = "John Doe")
        @JsonProperty("nombre") String name) {
}
