package rel.rel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rel.rel.entities.Company;

import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    public Optional<Company> findByEmailAndPassword(String email, String password);
    public boolean existsByEmailAndPassword(String email, String password);
}
