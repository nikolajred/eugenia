package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.RoleDTO;
import com.nix.eugenia.DTO.UserDTO;
import com.nix.eugenia.model.Role;
import com.nix.eugenia.model.User;
import com.nix.eugenia.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable long id) {
        User user = userService.getUser(id);
        return toDTO(user);
    }
    private UserDTO toDTO(User user){
        Set<RoleDTO> roleDTOS = toDTOs(user.getRoles());
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .startTime(user.getStartTime())
                .roles(roleDTOS)
                .build();
    }

    private Set<RoleDTO> toDTOs(Set<Role> role){
        return role.stream().map(role1 -> toDTO(role1)).collect(Collectors.toSet());
    }
    private RoleDTO toDTO(Role role){
        return RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

}
