package com.kbsec.kcou.coupon.service;

import com.kbsec.kcou.coupon.domain.Coupon;
import com.kbsec.kcou.coupon.domain.repository.CouponRepository;
import com.kbsec.kcou.coupon.dto.request.CouponCreateRequest;
import com.kbsec.kcou.coupon.dto.request.CouponUpdateRequest;
import com.kbsec.kcou.coupon.dto.response.CouponResponse;
import com.kbsec.kcou.coupon.dto.response.CouponsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public Long createCoupon(CouponCreateRequest request) {
        Coupon coupon = request.toEntity();
        Coupon savedCoupon = couponRepository.save(coupon);

        return savedCoupon.getId();
    }

    @Transactional
    public CouponsResponse getAllCoupons() {
        List<Coupon> coupons = couponRepository.findAll();
        return CouponsResponse.from(coupons);
    }

    @Transactional
    public CouponResponse updateCoupon(Long couponId, CouponUpdateRequest request) {
        Coupon coupon = couponRepository.getById(couponId);
        coupon.updateCoupon(
                request.price(),
                request.title(),
                request.quantity(),
                request.openedAt(),
                request.closedAt()
        );

        return CouponResponse.from(coupon);
    }

    @Transactional
    public void deleteCoupon(Long couponId) {
        couponRepository.deleteCouponById(couponId);
    }

}
