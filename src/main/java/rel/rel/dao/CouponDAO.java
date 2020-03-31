package rel.rel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rel.rel.entities.Coupon;
import rel.rel.repository.CouponRepository;

@Component
public class CouponDAO {

    private CouponRepository couponRepository;
    private CategoryDAO categoryDAO;

    @Autowired
    public CouponDAO(CouponRepository couponRepository, CategoryDAO categoryDAO) {
        this.couponRepository = couponRepository;
        this.categoryDAO = categoryDAO;
    }

    public Coupon save(Coupon coupon) throws Exception {
        if (coupon.getCompany() == null){
            throw new Exception("Company can not be null");
        }
        if (coupon.getCategory() == null){
            throw new Exception("Category can not be null");
        }
        coupon.setCategory(categoryDAO.createOrGetByName(coupon.getCategory()));
        try {
            return couponRepository.save(coupon);
        } catch (Exception e){
            throw new Exception("coupon already exists");
        }
    }
}
