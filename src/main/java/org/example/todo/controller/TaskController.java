package org.example.todo.controller;

import org.example.todo.dto.TaskRequest;
import org.example.todo.dto.TaskResponse;
import org.example.todo.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<TaskResponse> createStudent(
            @Valid @RequestBody TaskRequest request) {

        TaskResponse response =
                taskService.createTask(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllStudents() {

        return ResponseEntity.ok(
                taskService.getAllTasks()
        );
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getStudentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                taskService.getTaskById(id)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request) {

        return ResponseEntity.ok(
                taskService.updateTask(id, request)
        );
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id) {

        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }


}
