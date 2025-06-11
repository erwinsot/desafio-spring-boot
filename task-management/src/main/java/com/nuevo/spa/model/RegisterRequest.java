package com.nuevo.spa.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(
        name = "RegisterRequest",
        title = "Petición de Registro de  Usuario",
        description = """
        Objeto que representa una solicitud para registrar un nuevo usuario en el sistema.
        Incluye datos como el nombre de usuario, contraseña, nombre completo y correo electrónico.
        Todos los campos son obligatorios y deben cumplir con las validaciones especificadas.
        """
)
public record RegisterRequest(

        @Schema(description = "Nombre de usuario único", example = "usuario123")
        @NotBlank(message = "El nombre de usuario es obligatorio")
        @Size(min = 4, max = 20, message = "El nombre de usuario debe tener entre 4 y 20 caracteres")
        String username,

        @Schema(description = "Contraseña del usuario", example = "MiC0ntraseña$123")
        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        String password,

        @Schema(description = "Nombre completo del usuario", example = "Juan Pérez")
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @Schema(description = "Correo electrónico del usuario", example = "juan.perez@correo.com")
        @NotBlank(message = "El correo electrónico es obligatorio")
        @Email(message = "Debe ser un correo electrónico válido")
        String email

) {}
