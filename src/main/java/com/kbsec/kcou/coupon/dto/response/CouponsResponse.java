package com.kbsec.kcou.coupon.dto.response;

import com.kbsec.kcou.coupon.domain.Coupon;

import java.util.List;

public record CouponsResponse(
        List<CouponResponse> coupons
) {

    public static CouponsResponse from(List<Coupon> coupons) {
        return new CouponsResponse(
                coupons.stream().map(CouponResponse::from).toList()
        );
    }

}
