package com.nuevo.spa.controller;



import com.nuevo.spa.model.AuthRequest;
import com.nuevo.spa.model.AuthResponse;
import com.nuevo.spa.model.RegisterRequest;
import com.nuevo.spa.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticación", description = "Operaciones relacionadas con el inicio de sesión y registro de usuarios")
public class AuthController {

    private final AuthService authService;


    @Operation(
            summary = "Autenticación de usuario",
            description = "Permite a un usuario autenticarse y obtener un token JWT válido si las credenciales son correctas"
    )
    @PostMapping("/session")
    public ResponseEntity<AuthResponse> authenticateUser(@Valid @RequestBody AuthRequest request) throws Exception {
        AuthResponse response = authService.authenticateUser(request);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Registro de nuevo usuario",
            description = "Registra un nuevo usuario en el sistema con un rol predeterminado"
    )
    @PostMapping("/users")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
