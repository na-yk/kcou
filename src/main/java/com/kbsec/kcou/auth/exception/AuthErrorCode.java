package com.kbsec.kcou.auth.exception;

import com.kbsec.kcou.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode {

    NOT_SUPPORTED_PLATFORM("A001", "지원하지 않는 소셜 로그인 플랫폼입니다."),

    TOKEN_EMPTY("A002", "토큰이 존재하지 않습니다."),
    TOKEN_EXPIRED("A003", "토큰이 만료되었습니다."),
    TOKEN_INVALID("A004", "토큰이 유효하지 않습니다."),

    PLATFORM_TOKEN_REQUEST_FAILED("A005", "플랫폼에서 액세스 토큰을 획득하는 데 실패했습니다."),
    PLATFORM_USER_REQUEST_FAILED("A006", "플랫폼에서 사용자 정보를 획득하는 데 실패했습니다."),

    USER_NOT_FOUND("A007", "계정을 찾을 수 없습니다.");

    private final String code;
    private final String message;

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }

}
