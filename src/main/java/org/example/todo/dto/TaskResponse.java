package org.example.todo.dto;

import java.time.LocalDateTime;

public record TaskResponse(
        long id,
        String title,
        String description,
        LocalDateTime dueDate,
        boolean completed

) {
}
