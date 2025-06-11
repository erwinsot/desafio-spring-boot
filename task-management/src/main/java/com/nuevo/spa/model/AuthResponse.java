package com.nuevo.spa.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "AuthResponse",
        title = "Respuesta de Autenticación",
        description = "Objeto de respuesta que contiene el token JWT después de una autenticación exitosa"
)
public record AuthResponse
    ( @Schema(description = "Token JWT para autenticación", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
            String token)
{
}
