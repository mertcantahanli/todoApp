package todo.todoApp.businness.services;

import todo.todoApp.businness.dto.request.create.CreateTodoRequest;
import todo.todoApp.businness.dto.request.update.UpdateTodoRequest;
import todo.todoApp.businness.dto.response.create.CreateTodoResponse;
import todo.todoApp.businness.dto.response.get.GetAllTodoResponse;
import todo.todoApp.businness.dto.response.get.GetTodoResponse;
import todo.todoApp.businness.dto.response.update.UpdateTodoResponse;

import java.util.List;

public interface TodoService {
    List<GetAllTodoResponse> getAll();
    CreateTodoResponse add(CreateTodoRequest request);

    GetTodoResponse getById(String id);
    UpdateTodoResponse update(String id,UpdateTodoRequest request);

    void delete(String id);

    void changeState(String id);
}
