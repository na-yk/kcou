package com.kbsec.kcou.auth.oauth.dto;

import com.kbsec.kcou.auth.domain.Platform;
import com.kbsec.kcou.user.domain.User;

public interface OAuthUserInfoResponse {

    default User toUserEntity() {
        return new User(
                this.getPlatform(),
                this.getPlatformId()
        );
    }

    Platform getPlatform();

    String getPlatformId();

}
