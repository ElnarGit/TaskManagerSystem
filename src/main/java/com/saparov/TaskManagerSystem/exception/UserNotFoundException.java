package com.saparov.TaskManagerSystem.exception;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(Long id) {
        super("Пользователь с ID " + id + " не найден", "USER_NOT_FOUND");
    }
}