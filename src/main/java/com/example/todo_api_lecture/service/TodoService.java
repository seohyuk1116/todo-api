package com.example.todo_api_lecture.service;

import com.example.todo_api_lecture.entity.Todo;
import com.example.todo_api_lecture.repository.TodoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Page<Todo> getAllTodos(Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = todoRepository.findById(id).orElseThrow( () -> new RuntimeException("Todo no found"));
        todo.setTitle(todoDetails.getTitle());
        todo.setCompleted(todoDetails.getCompleted());
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow( () -> new RuntimeException("Todo no found"));
        todoRepository.delete(todo);
    }



}
