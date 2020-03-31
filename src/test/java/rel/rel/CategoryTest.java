package rel.rel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;
import rel.rel.dao.CategoryDAO;
import rel.rel.dao.CompanyDAO;
import rel.rel.entities.Category;
import rel.rel.entities.CategoryName;
import rel.rel.entities.Company;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles(profiles = "dev")
class CategoryTest {

    @Autowired
    private CategoryDAO categoryDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void createOrGet(){
        Category food = categoryDAO.createOrGetByName(new Category(CategoryName.FOOD));
        System.out.println(food);
    }
}
