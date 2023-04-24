package todo.todoApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoApp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
