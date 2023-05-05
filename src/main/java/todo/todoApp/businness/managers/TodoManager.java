package todo.todoApp.businness.managers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import todo.todoApp.businness.dto.TodoRequestDto;
import todo.todoApp.businness.dto.TodoResponseDto;
import todo.todoApp.businness.services.TodoService;
import todo.todoApp.model.Category;
import todo.todoApp.model.Todo;
import todo.todoApp.repositories.CategoryRepository;
import todo.todoApp.repositories.TodoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoManager implements TodoService {

    private final ModelMapper mapper;
    private final TodoRepository repository;
    private final CategoryRepository categoryRepository;


    @Override
    public List<TodoResponseDto> getAll() {
        List<Todo> todos = repository.findAll();
        List<TodoResponseDto> response= todos
                .stream()
                .map(todo -> mapper.map(todo,TodoResponseDto.class))
                .toList();
        return response;
    }

    @Override
    public TodoResponseDto add(TodoRequestDto todoRequestDto) {
        Todo todo =mapper.map(todoRequestDto,Todo.class);


        List<Category> categories = todoRequestDto.getCategoryIds().stream()
                .map(categoryId -> categoryRepository.findById(categoryId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        todo.setCategories(categories);

        repository.save(todo);
        TodoResponseDto response = mapper.map(todo , TodoResponseDto.class);
        return response;
    }

    @Override
    public TodoResponseDto getById(String id) {
        checkIfTodoExists(id);
        Todo todo =repository.findById(id).orElseThrow();
        
        TodoResponseDto response=mapper.map(todo,TodoResponseDto.class);
        return response;
    }

    @Override
    public TodoResponseDto update(String id,TodoRequestDto request) {
        checkIfTodoExists(id);
        Todo todo = mapper.map(request,Todo.class);
        todo.setId(id);

        repository.save(todo);

        TodoResponseDto response = mapper.map(todo,TodoResponseDto.class);
        return response;
    }

    @Override
    public void updateCategoryOfTodos(String id, TodoRequestDto request) {

        Todo todo = repository.findById(id).orElseThrow();

        List<Category> newCategories= request.getCategoryIds().stream()
                .map(categoryId -> categoryRepository.findById(categoryId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        List<Category> existingCategories = todo.getCategories();

        existingCategories.addAll(newCategories);

        todo.setCategories(existingCategories);

        repository.save(todo);

    }


    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
    public void changeState(String id){
        checkIfTodoExists(id);
        Todo todo = repository.findById(id).orElseThrow();
        if (todo.isState()){
            todo.setState(false);
        }else {
            todo.setState(true);
        }

       repository.save(todo);
    }
    public void checkIfTodoExists(String id){
        if (!repository.existsById(id)) throw new RuntimeException("not found id");
    }
}
