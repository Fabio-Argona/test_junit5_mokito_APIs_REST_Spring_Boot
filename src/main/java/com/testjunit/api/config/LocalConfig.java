package com.testjunit.api.config;

import com.testjunit.api.domain.User;
import com.testjunit.api.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void startDB() {
        User u1 = new User(null, "fabio", "Teste@email.com", "123");
        User u2 = new User(null, "Argona", "Argona@email.com", "321");

        repository.saveAll(List.of(u1, u2));
    }
}
