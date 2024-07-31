package com.kbsec.kcou.coupon.dto.response;

import com.kbsec.kcou.coupon.domain.Coupon;

import java.time.LocalDateTime;

public record CouponResponse(
        Long id,
        String title,
        LocalDateTime openedAt,
        LocalDateTime closedAt
) {

    public static CouponResponse from(Coupon coupon) {
        return new CouponResponse(
                coupon.getId(),
                coupon.getTitle(),
                coupon.getOpenedAt(),
                coupon.getClosedAt()
        );
    }

}
