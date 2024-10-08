package com.todoapp.todo.Repositories;

import com.todoapp.todo.models.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoModel, Long> {

    void deleteByTitle(String title);
}
