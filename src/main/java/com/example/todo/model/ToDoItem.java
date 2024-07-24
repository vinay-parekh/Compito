package com.example.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "to_do_items")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Enter the category of the task")
    private String category;

    private boolean complete;
}
