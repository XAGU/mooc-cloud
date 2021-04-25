package com.xagu.mooc.gateway.filter;

/**
 * @author xagu Created on 2020/9/13 Email:xagu_qc@foxmail.com Describe: TODO
 */

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.ParseException;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xagu
 * @date 2021/4/24
 */
@Slf4j
@Component
public class OauthGlobalFilter implements GlobalFilter, Ordered {

    @Resource
    private TokenStore tokenStore;


    @Resource
    private ObjectMapper objectMapper;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (StrUtil.isEmpty(token)) {
            return chain.filter(exchange);
        }

        //从token中解析用户信息并设置到Header中去
        String realToken = token.replace("bearer ", "");
        String username = "";
        try {
            OAuth2Authentication oAuth2Authentication = this.tokenStore
                .readAuthentication(realToken);
            username = (String) oAuth2Authentication.getPrincipal();
            log.info("AuthGlobalFilter.filter() user:{}", username);
        } catch (Exception e) {
            log.debug(e.getMessage());
        }
        ServerHttpRequest request = exchange.getRequest().mutate().header("user",
            username)
            .build();
        exchange = exchange.mutate().request(request).build();
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
 