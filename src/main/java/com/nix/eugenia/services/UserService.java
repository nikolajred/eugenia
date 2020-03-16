package com.nix.eugenia.services;

import com.nix.eugenia.model.Role;
import com.nix.eugenia.model.User;

public interface UserService {

    User getUser(Long id);

     void  setRole(Long userId, Long roleId);
}
