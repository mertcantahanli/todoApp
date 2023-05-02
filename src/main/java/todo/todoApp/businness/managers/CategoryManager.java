package todo.todoApp.businness.managers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import todo.todoApp.businness.dto.CategoryRequestDto;
import todo.todoApp.businness.dto.CategoryResponseDto;
import todo.todoApp.businness.services.CategoryService;
import todo.todoApp.model.Category;
import todo.todoApp.repositories.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final ModelMapper mapper;
    private final CategoryRepository repository;
    @Override
    public List<CategoryResponseDto> getAll() {
        List<Category> categories = repository.findAll();
        List<CategoryResponseDto> response= categories.stream()
                .map(category -> mapper.map(category,CategoryResponseDto.class))
                .toList();
        return response;
    }
    public CategoryResponseDto getById(String id){
        checkIfCategoryExists(id);
        Category category = repository.findById(id).orElseThrow();
        CategoryResponseDto response = mapper.map(category,CategoryResponseDto.class);
        return response;
    }

    @Override
    public CategoryResponseDto add(CategoryRequestDto request) {
        Category category = mapper.map(request,Category.class);
        checkIfTitleExist(request.getTitle());

        repository.save(category);
        CategoryResponseDto response = mapper.map(category ,CategoryResponseDto.class);
        return response;
    }

    @Override
    public CategoryResponseDto update(String id, CategoryRequestDto request) {
        checkIfCategoryExists(id);
        checkIfTitleExist(request.getTitle());
        Category category = mapper.map(request,Category.class);
       category.setId(id);
       repository.save(category);
        CategoryResponseDto response=mapper.map(category,CategoryResponseDto.class);
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
