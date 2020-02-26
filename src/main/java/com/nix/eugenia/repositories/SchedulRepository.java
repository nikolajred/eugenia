package com.nix.eugenia.repositories;

import com.nix.eugenia.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulRepository extends JpaRepository<Schedule, Long>{
}
