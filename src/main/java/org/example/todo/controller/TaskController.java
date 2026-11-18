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


}
