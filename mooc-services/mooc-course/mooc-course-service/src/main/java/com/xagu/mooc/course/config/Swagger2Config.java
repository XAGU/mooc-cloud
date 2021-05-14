package com.xagu.mooc.course.config;

/**
 * @author xagu Created on 2021/2/13 Email:xagu_qc@foxmail.com Describe: TODO
 */

import cn.hutool.core.collection.CollectionUtil;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Swagger API相关配置
 */
@Configuration
@EnableSwagger2WebMvc
@EnableKnife4j
public class Swagger2Config {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket createRestApi(){
        //schema
        List<GrantType> grantTypes=new ArrayList<>();
        //密码模式
        String passwordTokenUrl="http://localhost:7001/oauth2-service/oauth/token";
        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant=new ResourceOwnerPasswordCredentialsGrant(passwordTokenUrl);
        grantTypes.add(resourceOwnerPasswordCredentialsGrant);

        OAuth oAuth=new OAuthBuilder().name("oauth2")
            .grantTypes(grantTypes).build();
        //context
        //scope方位
        List<AuthorizationScope> scopes=new ArrayList<>();
        scopes.add(new AuthorizationScope("read","read all resources"));
        SecurityReference securityReference=new SecurityReference("oauth2",scopes.toArray(new AuthorizationScope[]{}));
        SecurityContext securityContext=new SecurityContext(CollectionUtil.newArrayList(securityReference),PathSelectors.ant("/api/**"));
        //schemas
        List<SecurityScheme> securitySchemes= CollectionUtil.newArrayList(oAuth);
        //securyContext
        List<SecurityContext> securityContexts=CollectionUtil.newArrayList(securityContext);

        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.xagu.mooc"))
            .paths(PathSelectors.any())
            .build()
            .securityContexts(securityContexts).securitySchemes(securitySchemes);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("micro-mooc-" + applicationName)
            .description(applicationName + "服务API文档")
            .contact("XAGU")
            .version("1.0")
            .build();
    }
}
