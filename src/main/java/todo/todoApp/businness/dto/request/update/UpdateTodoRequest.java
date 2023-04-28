package todo.todoApp.businness.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTodoRequest {
    private String content;
    private boolean state;
    private List<String> categories;

}
