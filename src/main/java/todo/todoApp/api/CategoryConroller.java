package todo.todoApp.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import todo.todoApp.businness.dto.request.create.CreateCategoryRequest;
import todo.todoApp.businness.dto.request.update.UpdateCategoryRequest;
import todo.todoApp.businness.dto.response.create.CreateCategoryResponse;
import todo.todoApp.businness.dto.response.get.GetAllCategoryResponse;
import todo.todoApp.businness.dto.response.get.GetCategoryResponse;
import todo.todoApp.businness.dto.response.update.UpdateCategoryResponse;
import todo.todoApp.businness.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryConroller {

    private final CategoryService categoryService;

    @GetMapping
    public List<GetAllCategoryResponse> getAll(){

        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable int id){
        return categoryService.getById(id);
    }

    @PostMapping
    public CreateCategoryResponse add(CreateCategoryRequest request){
        return categoryService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable int id, UpdateCategoryRequest request){
        return categoryService.update(id,request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }
}
