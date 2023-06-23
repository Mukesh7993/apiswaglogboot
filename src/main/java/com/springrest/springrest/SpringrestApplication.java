package com.springrest.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EntityScan
@EnableSwagger2
public class SpringrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestApplication.class, args);
	}

	@Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Posts API")
                .apiInfo(apiInfo())
                .select()
                .build();
    }

   

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("simplifyingtech API")
                .description("simplifyingtech API for developers")
                .termsOfServiceUrl("https://simplifyingtechcode.wordpress.com/")
                .licenseUrl("simplifyingtech@gmail.com")
                .version("2.0")
                .build();
    }

}
