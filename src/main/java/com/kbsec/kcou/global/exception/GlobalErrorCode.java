package com.kbsec.kcou.global.exception;

public enum GlobalErrorCode implements ErrorCode {

    INPUT_VALIDATION_ERROR("G002", "요청 정보가 바르지 않습니다.");

    private final String code;
    private final String message;

    GlobalErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
