package com.kbsec.kcou.auth.oauth.domain;

import com.kbsec.kcou.auth.domain.Platform;

import java.net.URI;

public interface AuthCodeRequestUrlProvider {

    Platform platform();

    URI provideUrl();

}
