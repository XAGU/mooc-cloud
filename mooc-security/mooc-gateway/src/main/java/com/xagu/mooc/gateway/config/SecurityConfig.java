package com.xagu.mooc.gateway.config;

import javax.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AuthenticationWebFilter;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @author xagu Created on 2021/2/13 Email:xagu_qc@foxmail.com Describe: TODO
 */
@AllArgsConstructor
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    private static final String MAX_AGE = "18000L";

    @Resource
    private AccessManager accessManager;


    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer(){
        JwtAccessTokenConverter jwtTokenEnhancer = new JwtAccessTokenConverter();
        jwtTokenEnhancer.setSigningKey("xagu-mooc");
        return jwtTokenEnhancer;
    }

    /**
     * 跨域配置
     */
    public WebFilter corsFilter() {
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            if (CorsUtils.isCorsRequest(request)) {
                HttpHeaders requestHeaders = request.getHeaders();
                ServerHttpResponse response = ctx.getResponse();
                HttpMethod requestMethod = requestHeaders.getAccessControlRequestMethod();
                HttpHeaders headers = response.getHeaders();
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestHeaders.getOrigin());
                headers.addAll(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders.getAccessControlRequestHeaders());
                if (requestMethod != null) {
                    headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, requestMethod.name());
                }
                headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
                headers.add(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "*");
                headers.add(HttpHeaders.ACCESS_CONTROL_MAX_AGE, MAX_AGE);
                if (request.getMethod() == HttpMethod.OPTIONS) {
                    response.setStatusCode(HttpStatus.OK);
                    return Mono.empty();
                }
            }
            return chain.filter(ctx);
        };
    }

    @Bean
    SecurityWebFilterChain webFluxSecurityFilterChain(ServerHttpSecurity http) throws Exception{
        //token管理器
        ReactiveAuthenticationManager tokenAuthenticationManager
            = new ReactiveJwtAuthenticationManager(tokenStore());
        //认证过滤器
        AuthenticationWebFilter authenticationWebFilter = new AuthenticationWebFilter(tokenAuthenticationManager);
        authenticationWebFilter.setServerAuthenticationConverter(new ServerBearerTokenAuthenticationConverter());

        http
            .httpBasic().disable()
            .csrf().disable()
            .cors().and()
            .headers().frameOptions().disable()
            .and()
            .authorizeExchange()
            .pathMatchers(HttpMethod.OPTIONS).permitAll()
            .anyExchange().access(accessManager)
            .and()
            //跨域过滤器
            // 跨域过滤器
            .addFilterAt(corsFilter(), SecurityWebFiltersOrder.CORS)
            //oauth2认证过滤器
            .addFilterAt(authenticationWebFilter, SecurityWebFiltersOrder.AUTHENTICATION);
        return http.build();
    }
}
