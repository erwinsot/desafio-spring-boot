package com.nuevo.spa.service;

import com.nuevo.spa.model.AuthRequest;
import com.nuevo.spa.model.AuthResponse;
import com.nuevo.spa.model.RegisterRequest;

public interface AuthService {
    public AuthResponse authenticateUser(AuthRequest authRequest);
    public String register(RegisterRequest authRequest);
}
