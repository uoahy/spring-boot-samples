package com.example.exception.service;

import com.example.exception.dto.TodoRequestDto;
import com.example.exception.entity.Todo;
import com.example.exception.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // 조회
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    // 생성
    public Todo addTodo(TodoRequestDto todoRequestDto) {
        return todoRepository.save(new Todo(todoRequestDto));
    }

    // 수정
    public Todo editTodo(Long todoId, TodoRequestDto todoRequestDto) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo " + todoId + " is not found"));
        todo.edit(todoRequestDto);
        return todoRepository.save(todo);
    }

    // 삭제
    public Long deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo " + todoId + " is not found"));
        todoRepository.delete(todo);
        return todoId;
    }

}
