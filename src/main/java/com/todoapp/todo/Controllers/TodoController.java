package com.todoapp.todo.Controllers;

import com.todoapp.todo.Services.TodoService;
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
        return "index";
    }
}
