package rel.rel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;
import rel.rel.dao.CompanyDAO;
import rel.rel.entities.Company;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles(profiles = "dev")
class CompanyTest {

    @Autowired
    private CompanyDAO companyDAO;

    @org.junit.jupiter.api.Test
    void contextLoads() {
    }

    @Test
    void Create() {
        Company company = new Company("yes_planet", "movie@cinema.com", "byebye");
        try {
            System.out.println(companyDAO.save(company));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void findCompanyById(){
        Optional<Company> opCompany = companyDAO.findById(3L);
        opCompany.ifPresent(System.out::println);
    }

    @Test
    void deleteCompany(){
        Company company = null;
        try {
            company = companyDAO.deleteCompanyById(3L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(company);
    }

    @Test
    void updateCompany(){
        Company company = new Company(1L, "aroma", "aroma2@walla.com", "444444");
        try {
            companyDAO.save(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void ByNameAndPassword(){
        Optional<Company> company = companyDAO.findByEmailAndPassword("giraffe@food.com", "hello");
        company.ifPresent(System.out::println);
    }

    @Test
    void logIn(){
        boolean exist = companyDAO.logIn("aroma2@walla.com4545", "444444");
        Assert.isTrue(exist, "bad email or pass");
    }
}
