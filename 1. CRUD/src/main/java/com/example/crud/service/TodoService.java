package com.example.crud.service;

import com.example.crud.entity.Todo;
import com.example.crud.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // 수정
    public Todo editTodo(Long todoId, String title) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(RuntimeException::new);
        todo.setTitle(title);
        return todoRepository.save(todo);
    }

    // 삭제
    public Long deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(RuntimeException::new);
        todoRepository.delete(todo);
        return todoId;
    }

}
