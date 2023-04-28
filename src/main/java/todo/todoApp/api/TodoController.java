package todo.todoApp.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import todo.todoApp.businness.dto.request.create.CreateTodoRequest;
import todo.todoApp.businness.dto.request.update.UpdateTodoRequest;
import todo.todoApp.businness.dto.response.create.CreateTodoResponse;
import todo.todoApp.businness.dto.response.get.GetAllTodoResponse;
import todo.todoApp.businness.dto.response.get.GetTodoResponse;
import todo.todoApp.businness.dto.response.update.UpdateTodoResponse;
import todo.todoApp.businness.services.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public List<GetAllTodoResponse> findAll() {
        return todoService.getAll();
    }
    @GetMapping("/{id}")
    public GetTodoResponse getById(@PathVariable String id){
        return todoService.getById(id);
    }

    @PostMapping
    public CreateTodoResponse add(@RequestBody CreateTodoRequest request) {
        return todoService.add(request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        todoService.delete(id);
    }
    @PutMapping("/{id}")
    public UpdateTodoResponse update(@PathVariable String id, UpdateTodoRequest request){
        return todoService.update(id,request);
    }
    @PutMapping("/{id}/state")
    public void changeState(@PathVariable String id){
       todoService.changeState(id);
    }
}
