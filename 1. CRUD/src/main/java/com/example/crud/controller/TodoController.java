package com.example.crud.controller;

import com.example.crud.entity.Todo;
import com.example.crud.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    // 조회
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    // 생성
    @PostMapping("/todos")
    public Todo postTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    // 수정
    @PutMapping("/todos/{todoId}")
    public Todo putTodo(@PathVariable Long todoId, @RequestBody String title) {
        return todoService.editTodo(todoId, title);
    }

    // 삭제
    @DeleteMapping("/todos/{todoId}")
    public Long deleteTodo(@PathVariable Long todoId) {
        return todoService.deleteTodo(todoId);
    }

}
