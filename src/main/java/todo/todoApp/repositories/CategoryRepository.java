package todo.todoApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import todo.todoApp.model.Category;

public interface CategoryRepository extends JpaRepository<Category,String> {

    boolean existsByTitle(String title);
}
