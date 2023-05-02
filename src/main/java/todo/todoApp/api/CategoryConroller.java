package todo.todoApp.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import todo.todoApp.businness.dto.CategoryRequestDto;
import todo.todoApp.businness.dto.CategoryResponseDto;
import todo.todoApp.businness.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryConroller {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDto> getAll(){

        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public CategoryResponseDto getById(@PathVariable String id){
        return categoryService.getById(id);
    }

    @PostMapping
    public CategoryResponseDto add(CategoryRequestDto request){
        return categoryService.add(request);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto update(@PathVariable String id, CategoryRequestDto request){
        return categoryService.update(id,request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        categoryService.delete(id);
    }
}
