package com.feng.yaxin.authority.config;

import com.feng.yaxin.authority.annotation.RestControllerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test");
        boolean acceptSwagger = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(acceptSwagger)
                .groupName("慕华")
                .select()
                //扫描接口的方式
                .apis(RequestHandlerSelectors.withClassAnnotation(RestControllerMapping.class))
                //过滤方式
//                .paths(PathSelectors.regex())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "用户权限模块",
                "Api Documentation",
                "1.0",
                "http://localhost:8080/api/account/query/10/1",
                new Contact("慕华", "", "aegon4targaryen@163.com"),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

//==============================================

    @Bean
    public Docket docket111(Environment environment) {
        Profiles profiles = Profiles.of("dev", "test");
        boolean acceptSwagger = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(acceptSwagger)
                .groupName("组2")
                .select()
                //扫描接口的方式
                .apis(RequestHandlerSelectors.withClassAnnotation(RestControllerMapping.class))
                //过滤方式
//                .paths(PathSelectors.regex())
                .build();
    }


}
