package com.da.innercrud1.dto;

import com.da.innercrud1.enums.Role;
import lombok.Data;

@Data
public class UserDto {

        private Long id;

        private String name;

        private String email;

        private Role Role;


}
