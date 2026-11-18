package org.example.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="desciption",nullable = false)
    private String description;

    @Column(name="due_date",nullable = false)
    private LocalDate dueDate;

    @Column(name="completed",nullable = false)
    private boolean completed;
}
