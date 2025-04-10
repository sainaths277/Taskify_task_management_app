package com.app.todoapp.services;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this class as a Spring service (business logic layer)
public class TaskService {

    // JPA Repository for database operations
    private final TaskRepository taskRepository;

    // Constructor injection of TaskRepository
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Retrieves all tasks from database
     * @return List of all tasks
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll(); // Uses JpaRepository method
    }

    /**
     * Creates and saves a new task
     * @param title Title of the new task
     */
    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false); // New tasks are incomplete by default
        taskRepository.save(task); // Persists to database
    }

    /**
     * Deletes a task by ID
     * @param id ID of task to delete
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id); // Uses JpaRepository method
    }

    /**
     * Toggles task completion status
     * @param id ID of task to toggle
     * @throws IllegalArgumentException if task not found
     */
    public void toggleTask(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
        task.setCompleted(!task.isCompleted()); // Flip completion status
        taskRepository.save(task); // Update in database
    }
}