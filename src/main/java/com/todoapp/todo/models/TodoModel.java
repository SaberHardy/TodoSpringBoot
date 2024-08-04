package com.todoapp.todo.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class TodoModel {
    private Long id;
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;
}
