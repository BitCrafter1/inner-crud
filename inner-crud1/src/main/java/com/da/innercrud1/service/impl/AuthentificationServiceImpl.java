package com.da.innercrud1.service.impl;


import com.da.innercrud1.dto.AuthRequest;
import com.da.innercrud1.dto.JwtAuthResponse;
import com.da.innercrud1.repository.CustomerRepository;
import com.da.innercrud1.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthentificationServiceImpl implements AuthService {

    private final CustomerRepository customerRepository;

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public JwtAuthResponse authenticate(AuthRequest authRequest) {
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
            (authRequest.getUsername(), authRequest.getPassword()));

var customer = customerRepository.findByEmail(authRequest.getUsername()).orElseThrow(()  -> new UsernameNotFoundException("Invalid Username"));
var jwt = jwtService.generateToken(customer);
var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), customer);

        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setToken(jwt);
        jwtAuthResponse.setRefreshToken(refreshToken);
        return jwtAuthResponse;
    }


}
