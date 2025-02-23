package com.project.todo_backend.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

    @Document(collection = "todos")  // This maps the class to a MongoDB collection
    public class Todo {

        @Id
        private String id;  // Unique ID for each todo
        private String task;
        private boolean completed;
        private LocalDateTime createdAt;

        // Constructors
        public Todo() {
            this.createdAt = LocalDateTime.now();
        }

        public Todo(String task, boolean completed) {
            this.task = task;
            this.completed = completed;
            this.createdAt = LocalDateTime.now();
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public String getTask() {
            return task;
        }

        public void setTask(String task) {
            this.task = task;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

    }
