package todo.todoApp.businness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequestDto {

    private String content;
    private boolean state;
    private List<String> categoryIds;

}
