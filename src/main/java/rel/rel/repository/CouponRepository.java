package rel.rel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rel.rel.entities.Coupon;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {
}
