package com.yuriy.ToDoList.service;

import com.yuriy.ToDoList.entity.UserEntity;
import com.yuriy.ToDoList.exception.UserAlreadyExistException;
import com.yuriy.ToDoList.exception.UserNotFoundException;
import com.yuriy.ToDoList.repository.UserRepo;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользоватеь с таким именем уже существует!");
        }
        return userRepo.save(user);
    }

    public UserEntity getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден!");
        }
        return user;
    }
}
