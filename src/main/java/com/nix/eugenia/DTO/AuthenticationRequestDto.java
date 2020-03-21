package com.nix.eugenia.DTO;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
