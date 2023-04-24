package todo.todoApp.businness.services;

import todo.todoApp.businness.dto.request.create.CreateCategoryRequest;
import todo.todoApp.businness.dto.request.update.UpdateCategoryRequest;
import todo.todoApp.businness.dto.response.create.CreateCategoryResponse;
import todo.todoApp.businness.dto.response.get.GetAllCategoryResponse;
import todo.todoApp.businness.dto.response.get.GetCategoryResponse;
import todo.todoApp.businness.dto.response.update.UpdateCategoryResponse;

import java.util.List;

public interface CategoryService {


    CreateCategoryResponse add(CreateCategoryRequest request);

    List<GetAllCategoryResponse> getAll();
    GetCategoryResponse getById(int id);

    UpdateCategoryResponse update(int id, UpdateCategoryRequest request);

   void delete(int id);
}
