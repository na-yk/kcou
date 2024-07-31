package com.kbsec.kcou.global.config;

import com.kbsec.kcou.auth.config.JwtProperties;
import com.kbsec.kcou.auth.config.KakaoOAuthProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {KakaoOAuthProperties.class, JwtProperties.class})
public class PropertiesConfig {
}
