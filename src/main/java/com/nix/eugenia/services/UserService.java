package com.nix.eugenia.services;

import com.nix.eugenia.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    public User getUser(Long id);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
