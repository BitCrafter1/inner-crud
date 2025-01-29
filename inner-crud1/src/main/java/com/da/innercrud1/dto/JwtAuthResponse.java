package com.da.innercrud1.dto;

import com.da.innercrud1.enums.Role;
import lombok.Data;

@Data
public class JwtAuthResponse {

    private String token;
    private String refreshToken;

}
