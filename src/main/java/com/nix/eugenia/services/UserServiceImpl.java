package com.nix.eugenia.services;

import com.nix.eugenia.model.Role;
import com.nix.eugenia.model.User;
import com.nix.eugenia.repositories.RoleRepository;
import com.nix.eugenia.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }


    @Override
    public void setRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId).get().;
        Role role = roleRepository.findById(roleId).get();


        user.addRole(role);
        role.getUsers().add(user);

        userRepository.save(user);



    }
}

