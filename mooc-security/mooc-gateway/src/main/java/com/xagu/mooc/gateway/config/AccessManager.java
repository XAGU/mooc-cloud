package com.xagu.mooc.gateway.config;

import com.alibaba.nacos.common.utils.ConcurrentHashSet;
import java.util.Collection;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author xagu Created on 2020/9/13 Email:xagu_qc@foxmail.com Describe: TODO
 */
@Slf4j
@Component
public class AccessManager implements ReactiveAuthorizationManager<AuthorizationContext> {
    private Set<String> permitAll = new ConcurrentHashSet<>();
    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();


    public AccessManager (){
        permitAll.add("/");
        permitAll.add("/error");
        permitAll.add("/favicon.ico");
        //如果生产环境开启swagger调试
        permitAll.add("/**/v2/api-docs/**");
        permitAll.add("/**/swagger-resources/**");
        permitAll.add("/webjars/**");
        permitAll.add("/doc.html");
        permitAll.add("/swagger-ui.html");
        permitAll.add("/**/oauth/**");
    }

    /**
     * 实现权限验证判断
     */
    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> authenticationMono, AuthorizationContext authorizationContext) {
        ServerWebExchange exchange = authorizationContext.getExchange();
        //请求资源
        ServerHttpRequest request = exchange.getRequest();
        String requestPath = request.getURI().getPath();

        // 是否直接放行
        if (permitAll(requestPath)) {
            return Mono.just(new AuthorizationDecision(true));
        }

        //token为空拒绝访问
        String authorization = request.getHeaders().getFirst("Authorization");
        if (!StringUtils.startsWithIgnoreCase(authorization, "bearer")) {
            return Mono.error(new InvalidTokenException("Authorization不能为空"));
        }

        return authenticationMono.map(auth -> {
            return new AuthorizationDecision(checkAuthorities(auth, requestPath));
        }).defaultIfEmpty(new AuthorizationDecision(false));

    }

    /**
     * 校验是否属于静态资源
     * @param requestPath 请求路径
     * @return
     */
    private boolean permitAll(String requestPath) {
        return permitAll.stream()
            .anyMatch(r -> ANT_PATH_MATCHER.match(r, requestPath));
    }


    /**
     * 权限校验
     * @author javadaily
     * @date 2020/8/4 16:47
     * @param auth 用户权限
     * @param requestPath 请求路径
     * @return
     */
    private boolean checkAuthorities(Authentication auth, String requestPath) {
        if(auth instanceof OAuth2Authentication){
            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

//            return authorities.stream()
//                .map(GrantedAuthority::getAuthority)
//                .filter(item -> !item.startsWith("role_"))
//                .anyMatch(permission -> ANT_PATH_MATCHER.match(permission, requestPath));
            return true;
        }

        return false;
    }
}