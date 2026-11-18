package org.example.todo.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskRequest(
        @NotBlank(message = "Task tittle is required")
        @Size(max = 100, message = "tittle must not exceed 100 characters")
        String title,

        @Size(max = 500, message = "tittle must not exceed 500 characters")
        String description,

        @Future(message = "Due date must be in the future")
        LocalDate dueDate,

        boolean completed
) {
}
