package com.example.todo.service;

import com.example.todo.model.ToDoItem;
import com.example.todo.model.ToDoItemViewModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public interface ToDoAppService {

    void get(Model model);
    void save(ToDoItem item, BindingResult result, Model model);
    void update(ToDoItemViewModel items);
    void deleteById(Long id);
}
