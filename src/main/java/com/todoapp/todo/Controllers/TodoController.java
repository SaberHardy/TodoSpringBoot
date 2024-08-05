package com.todoapp.todo.Controllers;

import com.todoapp.todo.Services.TodoService;
import com.todoapp.todo.models.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        // index is the name of the template
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("todo", new TodoModel());
        // add is the name of the template
        return "add-todo";
    }

    @PostMapping("/save")
    public String save(TodoModel todoModel) {
        todoService.saveTodo(todoModel);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditTodo(@PathVariable Long id, Model model) {
        model.addAttribute("todo", todoService.getTodoById(id));

        return "edit-todo";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id,
                             @ModelAttribute("todo") TodoModel todoModel) {
        TodoModel existingTodo = todoService.getTodoById(id);
//        System.out.println("Updated Todo: " + existingTodo);

        if (existingTodo != null) {
            existingTodo.setTitle(todoModel.getTitle());
            existingTodo.setDescription(todoModel.getDescription());
            existingTodo.setDueDate(todoModel.getDueDate());
            existingTodo.setCompleted(todoModel.isCompleted());

            todoService.saveTodo(existingTodo);
        }
        return "redirect:/";
    }
}
