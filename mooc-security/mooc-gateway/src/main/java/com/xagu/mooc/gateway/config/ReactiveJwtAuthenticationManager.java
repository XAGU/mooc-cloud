package com.xagu.mooc.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.server.resource.BearerTokenAuthenticationToken;
import reactor.core.publisher.Mono;

/**
 * @author xagu Created on 2021/2/13 Email:xagu_qc@foxmail.com Describe: TODO
 */
@Slf4j
public class ReactiveJwtAuthenticationManager implements ReactiveAuthenticationManager {

    private TokenStore tokenStore;

    public ReactiveJwtAuthenticationManager(TokenStore tokenStore){
        this.tokenStore = tokenStore;
    }



    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return Mono.justOrEmpty(authentication)
            .filter(a -> a instanceof BearerTokenAuthenticationToken)
            .cast(BearerTokenAuthenticationToken.class)
            .map(BearerTokenAuthenticationToken::getToken)
            .flatMap((accessToken ->{
                log.info("accessToken is :{}",accessToken);
                OAuth2AccessToken oAuth2AccessToken;
                try {
                    oAuth2AccessToken = this.tokenStore.readAccessToken(accessToken);
                }catch (InvalidTokenException e){
                    return Mono.error(new InvalidTokenException("Access Token无效!"));
                }
                //根据access_token从数据库获取不到OAuth2AccessToken
                if(oAuth2AccessToken == null){
                    return Mono.error(new InvalidTokenException("Access Token无效!"));
                }else if(oAuth2AccessToken.isExpired()){
                    return Mono.error(new InvalidTokenException("Access Token已过期,请重新获取!"));
                }

                OAuth2Authentication oAuth2Authentication =this.tokenStore.readAuthentication(accessToken);
                if(oAuth2Authentication == null){
                    return Mono.error(new InvalidTokenException("Access Token无效!"));
                }else {
                    return Mono.just(oAuth2Authentication);
                }
            })).cast(Authentication.class);
    }
}