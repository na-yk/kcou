package com.kbsec.kcou.coupon.domain.repository;

import com.kbsec.kcou.coupon.domain.Coupon;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    default Coupon getById(Long couponId) {
        return findById(couponId)
                .orElseThrow(() -> new EntityNotFoundException("찾을 수 없습니다."));
    }


    void deleteCouponById(Long couponId);

}
