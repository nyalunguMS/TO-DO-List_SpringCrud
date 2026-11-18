package org.example.todo.service;

import org.example.todo.dto.TaskRequest;
import org.example.todo.dto.TaskResponse;
import org.example.todo.entity.Task;
import org.example.todo.exceptions.ResourceNotFoundException;
import org.example.todo.exceptions.DuplicateResourceException;
import org.example.todo.repository.TaskRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // CREATE
    @Transactional
    public TaskResponse createTask(TaskRequest request) {

        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setCompleted(request.completed());

        Task savedTask = taskRepository.save(task);

        return mapToResponse(savedTask);
    }

    // READ ALL
    @Transactional(readOnly = true)
    public List<TaskResponse> getAllTasks() {

        return taskRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // READ ONE
    @Transactional(readOnly = true)
    public TaskResponse getTaskById(Long id) {

        Task task = findTaskId(id);

        return mapToResponse(task);
    }

    // UPDATE
    @Transactional
    public TaskResponse updateTask(Long id, TaskRequest request) {

        Task task = findTaskId(id);


        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setCompleted(request.completed());

        Task updatedTask = taskRepository.save(task);



        return mapToResponse(updatedTask);
    }

    // DELETE
    @Transactional
    public void deleteTask(Long id) {

        Task task = findTaskId(id);

        taskRepository.delete(task);
    }

    private Task findTaskId(Long id) {

        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Task not found with ID: " + id
                ));
    }

    private TaskResponse mapToResponse(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.isCompleted()
        );
    }

}
