package com.testjunit.api.services.impl;

import com.testjunit.api.domain.User;
import com.testjunit.api.domain.dto.UserDTO;
import com.testjunit.api.repositories.UserRepository;
import com.testjunit.api.services.UserService;
import com.testjunit.api.services.exceptions.DataIntegrityViolationException;
import com.testjunit.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User create(UserDTO obj) {
        findByEmail(obj);

        return repository.save(mapper.map(obj, User.class));
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if(user.isPresent()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
        }
    }

}
