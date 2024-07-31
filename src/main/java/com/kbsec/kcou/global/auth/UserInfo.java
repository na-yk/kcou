package com.kbsec.kcou.global.auth;

import com.kbsec.kcou.user.domain.User;

public record UserInfo(
        User user
) {

    public static UserInfo from(AuthContext authContext) {
        return new UserInfo(authContext.getUser());
    }

    public boolean isAuthenticated() {
        return this.user != null;
    }

}
