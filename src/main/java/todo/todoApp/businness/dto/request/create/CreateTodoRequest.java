package todo.todoApp.businness.dto.request.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateTodoRequest {

    private String content;
    private boolean state;
    private String categoryId;



}
