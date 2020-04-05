package com.nix.eugenia.repositories;

import com.nix.eugenia.model.TimePeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimePeriodRepository extends JpaRepository<TimePeriod, Long> {
}
