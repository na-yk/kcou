package com.kbsec.kcou.coupon.domain;


import com.kbsec.kcou.coupon.dto.request.CouponUpdateRequest;
import com.kbsec.kcou.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "coupons")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private long price;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private long quantity;

    @Column(columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime openedAt;

    @Column(columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime closedAt;

    @Builder
    public Coupon(long price, String title, long quantity, LocalDateTime openedAt, LocalDateTime closedAt) {
        this.price = price;
        this.title = title;
        this.quantity = quantity;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
    }

    public void updateCoupon(long price, String title, long quantity, LocalDateTime openedAt, LocalDateTime closedAt) {
        this.price = price;
        this.title = title;
        this.quantity = quantity;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
    }

}
