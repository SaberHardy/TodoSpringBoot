package com.todoapp.todo.Services;

import com.todoapp.todo.Repositories.TodoRepository;
import com.todoapp.todo.models.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoModel> getAllTodos() {
        return todoRepository.findAll();
    }

    public TodoModel getTodoById(Long id) {
        return todoRepository.findById(id).orElse(new TodoModel());
    }

    public void saveTodo(TodoModel todo) {
        todoRepository.save(todo);
    }

//    public void updateTodo(TodoModel todo) {
//        todoRepository.save(todo);
//    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}
