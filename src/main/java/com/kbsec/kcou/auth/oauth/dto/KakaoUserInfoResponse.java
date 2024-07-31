package com.kbsec.kcou.auth.oauth.dto;

import com.kbsec.kcou.auth.domain.Platform;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoUserInfoResponse implements OAuthUserInfoResponse {

    private Long id;

    @Override
    public Platform getPlatform() {
        return Platform.KAKAO;
    }

    @Override
    public String getPlatformId() {
        return Long.toString(this.id);
    }

}
