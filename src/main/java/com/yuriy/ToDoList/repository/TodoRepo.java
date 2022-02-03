package com.yuriy.ToDoList.repository;

import com.yuriy.ToDoList.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
