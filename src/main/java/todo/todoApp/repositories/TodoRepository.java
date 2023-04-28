package todo.todoApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoApp.model.Todo;

public interface TodoRepository extends JpaRepository<Todo,String> {

}
