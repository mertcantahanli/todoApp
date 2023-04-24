package todo.todoApp.businness.dto.response.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.todoApp.entities.Category;
import todo.todoApp.entities.Todo;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoResponse {

    private int id;
    private String content;
    private boolean state;

    private int categoryId;


}
