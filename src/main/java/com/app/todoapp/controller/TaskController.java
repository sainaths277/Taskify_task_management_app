package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // Marks this class as a Spring MVC Controller
public class TaskController {

    // Dependency injection of TaskService
    private final TaskService taskService;

    // Constructor-based dependency injection
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Handles GET requests to the root URL ("/")
     * Retrieves all tasks and passes them to the view
     * @param model Spring Model object to pass data to view
     * @return name of the Thymeleaf template to render ("tasks")
     */
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks); // Add tasks to model for Thymeleaf
        return "tasks"; // Corresponds to tasks.html template
    }

    /**
     * Handles POST requests to create a new task
     * @param title Task title from form input
     * @return redirect to root URL to refresh task list
     */
    @PostMapping
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/"; // Post-Redirect-Get pattern
    }

    /**
     * Handles task deletion
     * @param id Task ID from path variable
     * @return redirect to root URL
     */
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    /**
     * Handles toggling task completion status
     * @param id Task ID from path variable
     * @return redirect to root URL
     */
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }
}