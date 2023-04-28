package todo.todoApp.businness.dto.response.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoResponse {

    private String id;
    private String content;
    private boolean state;

    private String categoryId;



}
