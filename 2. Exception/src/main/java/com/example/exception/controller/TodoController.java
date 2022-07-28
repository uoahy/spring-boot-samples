package com.example.exception.controller;

import com.example.exception.dto.TodoRequestDto;
import com.example.exception.entity.Todo;
import com.example.exception.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Todo postTodo(@RequestBody @Valid TodoRequestDto todoRequestDto) {
        return todoService.addTodo(todoRequestDto);
    }

    // 수정
    @PutMapping("/todos/{todoId}")
    public Todo putTodo(@PathVariable Long todoId, @RequestBody @Valid TodoRequestDto todoRequestDto) {
        return todoService.editTodo(todoId, todoRequestDto);
    }

    // 삭제
    @DeleteMapping("/todos/{todoId}")
    public Long deleteTodo(@PathVariable Long todoId) {
        return todoService.deleteTodo(todoId);
    }

}
