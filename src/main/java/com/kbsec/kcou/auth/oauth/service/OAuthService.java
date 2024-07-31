package com.kbsec.kcou.auth.oauth.service;


import com.kbsec.kcou.auth.domain.JwtProvider;
import com.kbsec.kcou.auth.domain.Platform;
import com.kbsec.kcou.auth.domain.repository.UserRepository;
import com.kbsec.kcou.auth.oauth.dto.SignInResponse;
import com.kbsec.kcou.auth.oauth.dto.OAuthUserInfoResponse;
import com.kbsec.kcou.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class OAuthService {

    private final AuthCodeRequestService authCodeRequestService;
    private final OAuthClientService oAuthClientService;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public URI getAuthCodeRequestUrlProvider(Platform platform) {
        return authCodeRequestService.provideRequestUrl(platform);
    }

    public SignInResponse logIn(Platform platform, String authCode) {
        OAuthUserInfoResponse userInfo = oAuthClientService.getUserInfo(platform, authCode);

        if (!userRepository.existsByPlatformAndPlatformId(userInfo.getPlatform(), userInfo.getPlatformId())) {
            Long userId = signUp(userInfo);
        }

        User user = userRepository.getByPlatformAndPlatformId(userInfo.getPlatform(), userInfo.getPlatformId());

        String accessToken = jwtProvider.provideAccessToken(user);

        // TODO: 2023-10-26 리프레시 토큰 생성 로직 추가

        return SignInResponse.of(user.getId(), accessToken);
    }

    public Long signUp(OAuthUserInfoResponse userInfo) {
        User user = userInfo.toUserEntity();
        return userRepository.save(user).getId();
    }
}
