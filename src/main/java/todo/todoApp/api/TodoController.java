package todo.todoApp.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import todo.todoApp.businness.dto.TodoRequestDto;
import todo.todoApp.businness.dto.TodoResponseDto;
import todo.todoApp.businness.services.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<TodoResponseDto> findAll() {
        return todoService.getAll();
    }
    @GetMapping("/{id}")
    public TodoResponseDto getById(@PathVariable String id){
        return todoService.getById(id);
    }

    @PostMapping
    public TodoResponseDto add(@RequestBody TodoRequestDto request) {
        return todoService.add(request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        todoService.delete(id);
    }
    @PutMapping("/{id}")
    public TodoResponseDto update(@PathVariable String id, TodoRequestDto request){
        return todoService.update(id,request);
    }
    @PutMapping("/{id}/state")
    public void changeState(@PathVariable String id){
       todoService.changeState(id);
    }
}
