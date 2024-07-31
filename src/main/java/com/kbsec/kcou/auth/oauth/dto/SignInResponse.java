package com.kbsec.kcou.auth.oauth.dto;

public record SignInResponse(
        Long id,
        String accessToken
) {
    public static SignInResponse of(Long id, String accessToken) {

        return new SignInResponse(id, accessToken);
    }

}
