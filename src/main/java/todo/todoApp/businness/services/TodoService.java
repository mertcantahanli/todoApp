package todo.todoApp.businness.services;

import todo.todoApp.businness.dto.TodoRequestDto;
import todo.todoApp.businness.dto.TodoResponseDto;

import java.util.List;

public interface TodoService {
    List<TodoResponseDto> getAll();
    TodoResponseDto add(TodoRequestDto request);

    TodoResponseDto getById(String id);
    TodoResponseDto update(String id,TodoRequestDto request);

    void delete(String id);

    void changeState(String id);
}
