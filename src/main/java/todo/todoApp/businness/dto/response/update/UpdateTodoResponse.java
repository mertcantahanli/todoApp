package todo.todoApp.businness.dto.response.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTodoResponse {
    private int id;
    private String content;
    private boolean state;

    private int categoryId;



}
