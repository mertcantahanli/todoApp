package todo.todoApp.businness.managers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import todo.todoApp.Repositories.TodoRepository;
import todo.todoApp.businness.dto.request.create.CreateTodoRequest;
import todo.todoApp.businness.dto.request.update.UpdateTodoRequest;
import todo.todoApp.businness.dto.response.create.CreateTodoResponse;
import todo.todoApp.businness.dto.response.get.GetAllTodoResponse;
import todo.todoApp.businness.dto.response.get.GetTodoResponse;
import todo.todoApp.businness.dto.response.update.UpdateTodoResponse;
import todo.todoApp.businness.services.TodoService;
import todo.todoApp.entities.Todo;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoManager implements TodoService {

    private final ModelMapper mapper;
    private final TodoRepository repository;


    @Override
    public List<GetAllTodoResponse> getAll() {
        List<Todo> todos = repository.findAll();
        List<GetAllTodoResponse> response= todos
                .stream()
                .map(todo -> mapper.map(todo,GetAllTodoResponse.class))
                .toList();
        return response;
    }

    @Override
    public CreateTodoResponse add(CreateTodoRequest request) {
       Todo todo = mapper.map(request,Todo.class);
       todo.setId(0);
       todo.setState(true);
       repository.save(todo);
       CreateTodoResponse response = mapper.map(todo ,CreateTodoResponse.class);
       return response;
    }

    @Override
    public GetTodoResponse getById(int id) {
        Todo todo =repository.findById(id).orElseThrow();
        GetTodoResponse response=mapper.map(todo,GetTodoResponse.class);
        return response;
    }

    @Override
    public UpdateTodoResponse update(int id,UpdateTodoRequest request) {
        Todo todo = mapper.map(request,Todo.class);
        todo.setId(id);
        repository.save(todo);
        UpdateTodoResponse response = mapper.map(todo,UpdateTodoResponse.class);
        return response;
    }


    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    public void changeState(int id){
        Todo todo = repository.findById(id).orElseThrow();
        if (todo.isState()){
            todo.setState(false);
        }else {
            todo.setState(true);
        }

       repository.save(todo);
    }
}
