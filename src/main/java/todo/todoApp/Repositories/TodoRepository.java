package todo.todoApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoApp.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo,Integer> {

}
