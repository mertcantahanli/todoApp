package todo.todoApp.businness.services;

import todo.todoApp.businness.dto.CategoryRequestDto;
import todo.todoApp.businness.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {


    CategoryResponseDto add(CategoryRequestDto request);

    List<CategoryResponseDto> getAll();
    CategoryResponseDto getById(String id);

    CategoryResponseDto update(String id, CategoryRequestDto request);

   void delete(String id);
}
