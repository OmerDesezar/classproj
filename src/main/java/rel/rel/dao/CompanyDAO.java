package rel.rel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rel.rel.entities.Company;
import rel.rel.repository.CompanyRepository;

import java.util.Optional;

@Component
public class CompanyDAO {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyDAO(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company company) throws Exception {
        try{
             return companyRepository.save(company);
        } catch (Exception e) {
            throw new Exception("Company already exists");
        }
    }

    public Optional<Company> findById(Long id){
         return companyRepository.findById(id);
    }

    public Company deleteCompanyById(Long id) throws Exception{
        Optional<Company> opComp = findById(id);
        Company company = null;
        if (!opComp.isPresent()) {
            throw new Exception("company doesnt exist");
        }
        company = opComp.get();
        companyRepository.delete(company);
        return company;
    }

    public Optional<Company> findByEmailAndPassword(String email, String password){
            return companyRepository.findByEmailAndPassword(email,password);
    }

    public boolean logIn(String email, String password){
        return companyRepository.existsByEmailAndPassword(email,password);
    }




}
