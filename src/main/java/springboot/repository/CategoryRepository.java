package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
