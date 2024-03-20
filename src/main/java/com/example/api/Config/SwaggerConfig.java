package com.example.api.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static codeFusion.IntershipAPI.IntershipApplicationAPI.utils.Constants.APP_ROOT;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("Plateforme de recrutement des étudiants pour\n" +
                                        "des stages de perfectionnement ou de\n" +
                                        "soutenance.")
                                .title("Plateforme de recrutement des étudiants")
                                .build()
                )
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("codeFusion.IntershipAPI.IntershipApplicationAPI"))
                .paths(PathSelectors.ant(APP_ROOT+ "/**"))
                .build();
    }
}
