package com.kbsec.kcou.auth.domain;

import com.kbsec.kcou.global.exception.InvalidValueException;

import static com.kbsec.kcou.global.exception.GlobalErrorCode.INPUT_VALIDATION_ERROR;

public enum Platform {

    KAKAO;

    public static Platform from(String platformName) {
        try {
            return Platform.valueOf(platformName.toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new InvalidValueException(INPUT_VALIDATION_ERROR);
        }
    }

}
