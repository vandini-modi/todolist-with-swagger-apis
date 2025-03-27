package com.example.swagger_apis;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final Map<Long, TodoItem> todos = new HashMap<>();
    private long nextId = 1;

    // CREATE - Add a new todo
    @PostMapping
    public TodoItem addTodo(@RequestBody TodoItem item) {
        item.setId(nextId++);
        item.setCreatedAt(java.time.LocalDateTime.now());
        todos.put(item.getId(), item);
        return item;
    }

    // READ - Get all todos
    @GetMapping
    public List<TodoItem> getAllTodos() {
        return new ArrayList<>(todos.values());
    }

    // READ - Get todo by ID
    @GetMapping("/{id}")
    public TodoItem getTodoById(@PathVariable Long id) {
        return todos.get(id);
    }

    // UPDATE - Modify existing todo
    @PutMapping("/{id}")
    public TodoItem updateTodo(@PathVariable Long id, @RequestBody TodoItem updatedItem) {
        if (!todos.containsKey(id)) {
            throw new NoSuchElementException("Todo with ID " + id + " not found.");
        }
        updatedItem.setId(id);
        updatedItem.setCreatedAt(todos.get(id).getCreatedAt());
        todos.put(id, updatedItem);
        return updatedItem;
    }

    // DELETE - Remove todo by ID
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todos.remove(id);
        return "Todo with ID " + id + " deleted.";
    }
}
