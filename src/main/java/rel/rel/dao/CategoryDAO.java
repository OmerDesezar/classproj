package rel.rel.dao;

import jdk.nashorn.internal.runtime.options.OptionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rel.rel.entities.Category;
import rel.rel.entities.CategoryName;
import rel.rel.repository.CategoryRepository;

import java.util.Optional;

@Component
public class CategoryDAO {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> findByName(CategoryName name){
        return categoryRepository.findByName(name);
    }

    public Category createOrGetByName(Category category){
        Optional<Category> opCat = findByName(category.getName());
        if (opCat.isPresent()){
            return opCat.get();
        }
        return categoryRepository.save(category);
   }
}
