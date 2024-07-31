package com.kbsec.kcou.coupon.dto.request;

import com.kbsec.kcou.coupon.domain.Coupon;

import java.time.LocalDateTime;

public record CouponCreateRequest(
        String title,
        long price,
        long quantity,
        LocalDateTime openedAt,
        LocalDateTime closedAt
) {

    public Coupon toEntity() {
        return Coupon.builder()
                .title(title)
                .price(price)
                .quantity(quantity)
                .openedAt(openedAt)
                .closedAt(closedAt)
                .build();
    }

}
