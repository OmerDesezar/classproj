package rel.rel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rel.rel.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
