package com.nix.eugenia;

import com.nix.eugenia.model.Student;
import com.nix.eugenia.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



    @Configuration
    @Slf4j
    class LoadDatabase {

        @Bean
        CommandLineRunner initDatabase(StudentRepository repository) {
            return args -> {
                log.info("Preloading " + repository.save(new Student("Vadym Kiiashko", "activeStudent")));
                log.info("Preloading " + repository.save(new Student("Nick Red", "potentialStudent")));
            };
        }
    }

