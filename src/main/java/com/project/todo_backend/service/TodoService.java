package com.project.todo_backend.service;


import com.project.todo_backend.model.Todo;
import com.project.todo_backend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(String id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(String id, Todo newTodo) {
        return todoRepository.findById(id)
                .map(todo -> {
                    todo.setTask(newTodo.getTask());
                    todo.setCompleted(newTodo.isCompleted());
                    return todoRepository.save(todo);
                }).orElse(null);
    }

    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }
}
