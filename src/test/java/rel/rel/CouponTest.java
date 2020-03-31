package rel.rel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import rel.rel.dao.CategoryDAO;
import rel.rel.dao.CompanyDAO;
import rel.rel.dao.CouponDAO;
import rel.rel.entities.Category;
import rel.rel.entities.CategoryName;
import rel.rel.entities.Company;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles(profiles = "dev")
class CouponTest {

    @Autowired
    private CouponDAO couponDAO;

    @Autowired
    private CompanyDAO companyDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void create(){
        Optional<Company> opComp = companyDAO.findById(1L);

    }
}
