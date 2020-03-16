package com.nix.eugenia.DTO;

import com.nix.eugenia.model.Role;
import lombok.*;


import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private Date startTime;
    private List<RoleDTO> roles;
}
