package com.example.todo_api_lecture.dto;


import com.example.todo_api_lecture.entity.Todo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoDto {
    private Long id;
    private String title;
    private boolean completed;

    public  TodoDto(Todo todo){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.completed = todo.getCompleted();
    }

}
