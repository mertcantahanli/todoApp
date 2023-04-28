package todo.todoApp.businness.managers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import todo.todoApp.repositories.CategoryRepository;
import todo.todoApp.businness.dto.request.create.CreateCategoryRequest;
import todo.todoApp.businness.dto.request.update.UpdateCategoryRequest;
import todo.todoApp.businness.dto.response.create.CreateCategoryResponse;
import todo.todoApp.businness.dto.response.get.GetAllCategoryResponse;
import todo.todoApp.businness.dto.response.get.GetCategoryResponse;
import todo.todoApp.businness.dto.response.update.UpdateCategoryResponse;
import todo.todoApp.businness.services.CategoryService;
import todo.todoApp.model.Category;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final ModelMapper mapper;
    private final CategoryRepository repository;
    @Override
    public List<GetAllCategoryResponse> getAll() {
        List<Category> categories = repository.findAll();
        List<GetAllCategoryResponse> response= categories.stream()
                .map(category -> mapper.map(category,GetAllCategoryResponse.class))
                .toList();
        return response;
    }
    public GetCategoryResponse getById(String id){
        checkIfCategoryExists(id);
        Category category = repository.findById(id).orElseThrow();
        GetCategoryResponse response = mapper.map(category,GetCategoryResponse.class);
        return response;
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        Category category = mapper.map(request,Category.class);
        checkIfTitleExist(request.getTitle());

        repository.save(category);
        CreateCategoryResponse response = mapper.map(category ,CreateCategoryResponse.class);
        return response;
    }

    @Override
    public UpdateCategoryResponse update(String id, UpdateCategoryRequest request) {
        checkIfCategoryExists(id);
        checkIfTitleExist(request.getTitle());
        Category category = mapper.map(request,Category.class);
       category.setId(id);
       repository.save(category);
       UpdateCategoryResponse response=mapper.map(category,UpdateCategoryResponse.class);
        return response;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    private void checkIfCategoryExists(String id){
        if (!repository.existsById(id)) throw new RuntimeException("not found id");
    }
    public void checkIfTitleExist(String name){
        if ( repository.existsByTitle(name)) throw new RuntimeException("this category exist");
    }
}
