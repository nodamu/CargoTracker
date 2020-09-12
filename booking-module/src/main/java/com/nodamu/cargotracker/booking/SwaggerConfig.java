package com.nodamu.cargotracker.booking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author profnick
 * 9/12/20
 **/

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo getApiInfo(){
        return new ApiInfo(
                "Cargo Tracking App",
                "Cargo tracking project DDD",
                "1.0.0",
                "Terms of Service",
                new Contact("Nicholas Adamu", "nickadamu.live", "nickadamu@gmail.com"),
                "",
                "",
                Collections.emptyList());
    }
}
