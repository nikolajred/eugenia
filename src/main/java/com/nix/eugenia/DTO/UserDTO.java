package com.nix.eugenia.DTO;

import lombok.*;


import java.util.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
    private long id;
    private String email;
    private String password;
    private Date startTime;
}
