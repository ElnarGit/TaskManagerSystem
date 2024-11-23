package com.saparov.TaskManagerSystem.service;

import com.saparov.TaskManagerSystem.model.User;

import java.util.Optional;

public interface UserService extends GenericService<User, Long> {
    Optional<User> getByEmail(String email);
}
