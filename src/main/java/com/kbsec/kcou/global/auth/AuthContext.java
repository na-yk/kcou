package com.kbsec.kcou.global.auth;

import com.kbsec.kcou.auth.domain.repository.UserRepository;
import com.kbsec.kcou.user.domain.User;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Getter
@Component
@RequestScope
public class AuthContext {

    private User user;


    public void registerAuth(User user) {
        this.user = user;
    }

}

