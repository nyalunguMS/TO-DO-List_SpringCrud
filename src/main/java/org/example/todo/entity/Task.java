package org.example.todo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @Column(name="Tittle",nullable = false)
    private String title;

    @Column(name="Desciption",nullable = false)
    private String description;

    @Column(name="DueDate",nullable = false)
    private LocalDateTime dueDate;

    @Column(name="Completed",nullable = false)
    private boolean completed;
}
