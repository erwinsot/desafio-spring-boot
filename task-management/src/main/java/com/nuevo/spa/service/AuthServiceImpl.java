package com.nuevo.spa.service;


import com.nuevo.spa.entity.User;
import com.nuevo.spa.error.InvalidCredentialsException;
import com.nuevo.spa.error.UserExistException;
import com.nuevo.spa.model.*;
import com.nuevo.spa.repository.UserRepository;
import com.nuevo.spa.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;


    @Override
    public AuthResponse authenticateUser(AuthRequest authRequest)  {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.username(),
                            authRequest.password()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.username());
            String token = jwtService.generateToken(userDetails);

            return new AuthResponse(token);
        }catch (BadCredentialsException e){
            throw new InvalidCredentialsException("Usuario o contraseña incorrectos");

        }
    }


    @Override
    public String register(RegisterRequest authRequest) {
        if (userRepository.existsByUsername(authRequest.username())) {
            throw new UserExistException("El nombre de usuario ya existe");
        }
        User user = User.builder()
                .username(authRequest.username())
                .password(passwordEncoder.encode(authRequest.password()))
                .nombre(authRequest.nombre())
                .email(authRequest.email())
                .rol(User.Rol.ROLE_USER)
                .tasks(List.of())
                .build();

        userRepository.save(user);

        return "Usuario registrado correctamente";
    }



}
