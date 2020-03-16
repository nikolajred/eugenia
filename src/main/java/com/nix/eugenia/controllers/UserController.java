package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.RoleDTO;
import com.nix.eugenia.DTO.UserDTO;
import com.nix.eugenia.model.Role;
import com.nix.eugenia.model.User;
import com.nix.eugenia.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        return toDTO(user);
    }
    private UserDTO toDTO(User user){
        List<RoleDTO> roleDTOS = toDTOs(user.getRoles());
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .startTime(user.getStartTime())
                .roles(roleDTOS)
                .build();
    }

    private List<RoleDTO> toDTOs(List<Role> role){
        return role.stream().map(role1 -> toDTO(role1)).collect(Collectors.toList());
    }
    private RoleDTO toDTO(Role role){
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

}
