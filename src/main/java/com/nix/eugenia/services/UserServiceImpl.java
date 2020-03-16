package com.nix.eugenia.services;

import com.nix.eugenia.model.User;
import com.nix.eugenia.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }
}
