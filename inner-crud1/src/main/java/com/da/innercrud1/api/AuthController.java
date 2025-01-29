package com.da.innercrud1.api;

import com.da.innercrud1.dto.AuthRequest;
import com.da.innercrud1.dto.JwtAuthResponse;
import com.da.innercrud1.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {


    private final AuthService authService;


    @PostMapping("/authenticate")
    public ResponseEntity<JwtAuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.authenticate(authRequest));

    }

}
