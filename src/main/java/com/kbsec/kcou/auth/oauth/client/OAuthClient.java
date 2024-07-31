package com.kbsec.kcou.auth.oauth.client;

import com.kbsec.kcou.auth.domain.Platform;
import com.kbsec.kcou.auth.oauth.dto.OAuthUserInfoResponse;

public interface OAuthClient {

    Platform getPlatform();

    String getAccessToken(String authCode);

    OAuthUserInfoResponse getPlatformUserInfo(String accessToken);
}
