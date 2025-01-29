package com.da.innercrud1.service;

import com.da.innercrud1.dto.AuthRequest;
import com.da.innercrud1.dto.JwtAuthResponse;

public interface AuthService {
JwtAuthResponse authenticate(AuthRequest authRequest);
}
