package todo.todoApp.businness.dto.response.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.todoApp.entities.Category;
import todo.todoApp.entities.Todo;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryResponse {

    private int id;

    private String title;




}
