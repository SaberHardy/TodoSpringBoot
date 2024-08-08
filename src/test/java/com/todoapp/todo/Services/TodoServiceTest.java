package com.todoapp.todo.Services;

import com.todoapp.todo.Repositories.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

// @ExtendWith(MockitoExtension.class) is used to create a mock object for the class.
@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;
    // private AutoCloseable autoCloseable;
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        // autoCloseable = MockitoAnnotations.openMocks(this);
        todoService = new TodoService(todoRepository);
    }

    // @AfterEach
    // void tearDown() throws Exception {
    //    autoCloseable.close();
    // }

    @Test
    void getAllTodos() {
        todoService.getAllTodos();

        Mockito.verify(todoRepository, Mockito.times(1)).findAll();
    }

    @Test
    void getTodoById() {
        todoService.getTodoById(1L);

        Mockito.verify(todoRepository, Mockito.times(1)).findById(1L);
    }
}