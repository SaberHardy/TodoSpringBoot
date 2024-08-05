package com.todoapp.todo.Controllers;

import com.todoapp.todo.Services.TodoService;
import com.todoapp.todo.models.TodoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

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
}
