package com.kbsec.kcou.auth.oauth.service;

import com.kbsec.kcou.auth.domain.Platform;
import com.kbsec.kcou.auth.oauth.client.OAuthClient;
import com.kbsec.kcou.auth.oauth.dto.OAuthUserInfoResponse;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class OAuthClientService {

    private final Map<Platform, OAuthClient> clientMap;

    public OAuthClientService(Set<OAuthClient> clients) {
        this.clientMap = clients.stream()
                .collect(Collectors.toUnmodifiableMap(
                        OAuthClient::getPlatform,
                        Function.identity()
                ));
    }

    public OAuthUserInfoResponse getUserInfo(Platform platform, String authCode) {
        OAuthClient oAuthClient = clientMap.get(platform);
        String accessToken = oAuthClient.getAccessToken(authCode);
        return oAuthClient.getPlatformUserInfo(accessToken);
    }

}

