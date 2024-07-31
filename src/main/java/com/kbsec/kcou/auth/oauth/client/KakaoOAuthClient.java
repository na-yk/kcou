package com.kbsec.kcou.auth.oauth.client;

import com.kbsec.kcou.auth.domain.Platform;
import com.kbsec.kcou.auth.config.KakaoOAuthProperties;
import com.kbsec.kcou.auth.oauth.dto.KakaoToken;
import com.kbsec.kcou.auth.oauth.dto.OAuthUserInfoResponse;
import com.kbsec.kcou.auth.oauth.dto.KakaoUserInfoResponse;
import com.kbsec.kcou.global.exception.InvalidValueException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import static com.kbsec.kcou.global.exception.GlobalErrorCode.INPUT_VALIDATION_ERROR;

@Component
@RequiredArgsConstructor
public class KakaoOAuthClient implements OAuthClient {

    private static final String GRANT_TYPE = "authorization_code";
    private static final String REQUEST_TOKEN_URL = "https://kauth.kakao.com/oauth/token";
    private static final String REQUEST_USER_INFO_URL = "https://kapi.kakao.com/v2/user/me";
    private final KakaoOAuthProperties kakaoOAuthProperties;
    private final RestTemplate restTemplate;

    @Override
    public Platform getPlatform() {
        return Platform.KAKAO;
    }

    @Override
    public String getAccessToken(String authCode) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", GRANT_TYPE);
        body.add("client_id", kakaoOAuthProperties.getClientId());
        body.add("redirect_uri", kakaoOAuthProperties.getRedirectUri());
        body.add("client_secret", kakaoOAuthProperties.getClientSecret());
        body.add("code", authCode);

        try {
            KakaoToken token = restTemplate.postForObject(
                    REQUEST_TOKEN_URL,
                    new HttpEntity<>(body, httpHeaders),
                    KakaoToken.class
            );

            if (token == null) {
                throw new InvalidValueException(INPUT_VALIDATION_ERROR);
            }

            return token.accessToken();
        } catch (HttpStatusCodeException exception) {
            throw new InvalidValueException(INPUT_VALIDATION_ERROR);
        }
    }

    @Override
    public OAuthUserInfoResponse getPlatformUserInfo(String accessToken) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.setBearerAuth(accessToken);

        try {
            KakaoUserInfoResponse response = restTemplate.postForObject(
                    REQUEST_USER_INFO_URL,
                    new HttpEntity<>(httpHeaders),
                    KakaoUserInfoResponse.class
            );

            if (response == null) {
                throw new InvalidValueException(INPUT_VALIDATION_ERROR);
            }

            return response;
        } catch (HttpStatusCodeException exception) {
            throw new InvalidValueException(INPUT_VALIDATION_ERROR);
        }
    }

}
