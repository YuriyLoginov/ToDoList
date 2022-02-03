package com.yuriy.ToDoList.controller;

import com.yuriy.ToDoList.entity.TodoEntity;
import com.yuriy.ToDoList.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoEntity todo,
                                        @RequestParam Long userid) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }

    @PutMapping
    public ResponseEntity<?> completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.completeTodo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка!");
        }
    }
}
