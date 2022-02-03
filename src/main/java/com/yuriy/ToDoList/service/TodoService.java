package com.yuriy.ToDoList.service;

import com.yuriy.ToDoList.entity.TodoEntity;
import com.yuriy.ToDoList.entity.UserEntity;
import com.yuriy.ToDoList.model.Todo;
import com.yuriy.ToDoList.repository.TodoRepo;
import com.yuriy.ToDoList.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepo todoRepo;
    private final UserRepo userRepo;

    public TodoService(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
