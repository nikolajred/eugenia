package com.nix.eugenia.repositories;

import com.nix.eugenia.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
