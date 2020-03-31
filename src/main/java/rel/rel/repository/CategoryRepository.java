package rel.rel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rel.rel.entities.Category;
import rel.rel.entities.CategoryName;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByName(CategoryName name);
}
