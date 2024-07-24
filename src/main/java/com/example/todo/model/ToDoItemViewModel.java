package com.example.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoItemViewModel {
    private List<ToDoItem> todoList = new ArrayList<>();
    public ToDoItemViewModel(Iterable<ToDoItem> list) {
        list.forEach(todoList::add);
    }
}
