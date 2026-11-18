package org.example.todo.dto;

import java.time.LocalDate;

public record TaskResponse(
        long id,
        String title,
        String description,
        LocalDate dueDate,
        boolean completed

) {
}
