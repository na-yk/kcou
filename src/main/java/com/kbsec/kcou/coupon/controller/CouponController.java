package com.kbsec.kcou.coupon.controller;


import com.kbsec.kcou.coupon.dto.request.CouponCreateRequest;
import com.kbsec.kcou.coupon.dto.request.CouponUpdateRequest;
import com.kbsec.kcou.coupon.dto.response.CouponResponse;
import com.kbsec.kcou.coupon.dto.response.CouponsResponse;
import com.kbsec.kcou.coupon.service.CouponService;
import com.kbsec.kcou.global.auth.Auth;
import com.kbsec.kcou.global.auth.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping("")
    public ResponseEntity<Void> createCoupon(@Auth UserInfo userInfo, @RequestBody CouponCreateRequest request) {
        Long couponId = couponService.createCoupon(request);

        return ResponseEntity.created(
                URI.create(String.format("/api/v1/coupons/%d", couponId))
        ).build();
    }

    @GetMapping("")
    public ResponseEntity<CouponsResponse> getAllCoupons() {
        CouponsResponse response = couponService.getAllCoupons();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{couponId}")
    public ResponseEntity<CouponResponse> updateCoupon(@PathVariable Long couponId, CouponUpdateRequest request) {
        CouponResponse response = couponService.updateCoupon(couponId, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{couponId}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Long couponId) {
        couponService.deleteCoupon(couponId);

        return ResponseEntity.noContent().build();
    }

}
