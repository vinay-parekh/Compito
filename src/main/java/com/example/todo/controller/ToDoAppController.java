package com.example.todo.controller;

import com.example.todo.model.ToDoItem;
import com.example.todo.model.ToDoItemViewModel;
import com.example.todo.repository.ToDoItemRepository;
import com.example.todo.service.ToDoAppService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ToDoAppController {

    private ToDoAppService toDoAppService;

    @GetMapping("/")
    public String get(Model model) {
        toDoAppService.get(model);
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("newitem") @Valid ToDoItem item, BindingResult result, Model model) {
        toDoAppService.save(item, result, model);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ToDoItemViewModel items){
        toDoAppService.update(items);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        toDoAppService.deleteById(id);
        return "redirect:/";
    }
}