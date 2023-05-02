package todo.todoApp.businness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import todo.todoApp.model.Category;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponseDto {
    private String id;
    private String content;
    private boolean state;
    private List<Category> categories;
}
