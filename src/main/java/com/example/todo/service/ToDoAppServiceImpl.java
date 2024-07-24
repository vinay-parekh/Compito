package com.example.todo.service;

import com.example.todo.model.ToDoItem;
import com.example.todo.model.ToDoItemViewModel;
import com.example.todo.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Service
public class ToDoAppServiceImpl implements ToDoAppService{

    @Autowired
    private ToDoItemRepository repository;


    @Override
    public void get(Model model) {
        Iterable<ToDoItem> list = repository.findAll();
        model.addAttribute("items", new ToDoItemViewModel(list));
        model.addAttribute("newitem", new ToDoItem());
    }

    @Override
    public void save(ToDoItem item, BindingResult result, Model model) {
        if(result.hasErrors()) {
            Iterable<ToDoItem> list = repository.findAll();
            model.addAttribute("items", new ToDoItemViewModel(list));
            model.addAttribute("newitem", item);
        }
        repository.save(item);
    }

    @Override
    public void update(ToDoItemViewModel items) {
        for (ToDoItem item: items.getTodoList()) {
            ToDoItem toDoItem = ToDoItem.builder()
                    .id(item.getId())
                    .name(item.getName())
                    .category(item.getCategory())
                    .complete(item.isComplete())
                    .build();
            repository.save(toDoItem);
        }
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
