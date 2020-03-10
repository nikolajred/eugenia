package com.nix.eugenia.controllers;

import com.nix.eugenia.DTO.UserDTO;
import com.nix.eugenia.model.User;
import com.nix.eugenia.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


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
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .startTime(user.getStartTime())
                .build();
    }

}
