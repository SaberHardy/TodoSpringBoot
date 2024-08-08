package com.todoapp.todo.Services;

import com.todoapp.todo.Repositories.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.Mock;


class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;
    private AutoCloseable autoCloseable;
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        todoService = new TodoService(todoRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getAllTodos() {
        todoService.getAllTodos();

        Mockito.verify(todoRepository, Mockito.times(1)).findAll();
    }
}