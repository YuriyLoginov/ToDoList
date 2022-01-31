package com.yuriy.ToDoList.controller;

import com.yuriy.ToDoList.entity.UserEntity;
import com.yuriy.ToDoList.exception.UserAlreadyExistException;
import com.yuriy.ToDoList.exception.UserNotFoundException;
import com.yuriy.ToDoList.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return  ResponseEntity.ok("Пользоватеь успешно сохранён!");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }


    @GetMapping
    public ResponseEntity<?> getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
