package com.app.todoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // Marks this class as a JPA entity (maps to database table)
@Data // Lombok annotation - generates getters, setters, toString, etc.
public class Task {
    @Id // Marks this field as primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-generates ID values
    private Long id;

    private String title; // Task description
    private boolean completed; // Completion status flag
}