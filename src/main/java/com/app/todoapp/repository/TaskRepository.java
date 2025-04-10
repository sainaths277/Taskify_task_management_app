package com.app.todoapp.repository;

import com.app.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository interface for Task entities
 * Inherits CRUD operations from JpaRepository
 * Spring Data JPA automatically implements this interface
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    // No need to implement methods - Spring provides:
    // save(), findAll(), findById(), deleteById(), etc.
}