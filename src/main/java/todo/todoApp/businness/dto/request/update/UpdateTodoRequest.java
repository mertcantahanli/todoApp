package todo.todoApp.businness.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTodoRequest {
    private String content;
    private boolean state;
    private int categoryId;

}
