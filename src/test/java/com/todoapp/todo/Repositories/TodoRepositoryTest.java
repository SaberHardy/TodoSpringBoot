package com.todoapp.todo.Repositories;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.beans.factory.annotation.Autowired;
import com.todoapp.todo.models.TodoModel;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class TodoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;

    @Test
    void checkIfDeletedByTitle() {
        // Given
        TodoModel todoModel = new TodoModel(
                1L,
                "test",
                "some description",
                "01-01-2022",
                false
        );
        todoRepository.save(todoModel);
        // When
        todoRepository.deleteByTitle("test");
        // Then
        // use assertThat
        assertThat(todoRepository.findById(1L)).isEmpty();
    }
}