package com.lhwl.wzk.config;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/** 
*  @auter mrli
*  @date  2020/8/31
*  @desc
**/ 
@Data
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig {
    private String title;
    private String desc;
    private String version;
    private String termsOfServiceUrl;
    private String license;
    private String licenseUrl;
    private String basePackage;
    private String groupName;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(desc).version(version).termsOfServiceUrl(termsOfServiceUrl)
                .licenseUrl(licenseUrl).license(license).contact(new Contact(contactName, contactUrl, contactEmail))
                .build();
    }

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName(groupName)
                .directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, customerResponseMessage())
                .globalResponseMessage(RequestMethod.GET, customerResponseMessage())
                .forCodeGeneration(true).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any())
                .build();
    }
    private List<ResponseMessage> customerResponseMessage() {
        List<ResponseMessage> list = new ArrayList<>();
        list.add(new ResponseMessageBuilder().code(200).message("请求成功").build());
        list.add(new ResponseMessageBuilder().code(400).message("请求失败,具体查看返回业务状态码与对应消息").build());
        list.add(new ResponseMessageBuilder().code(2001).message("用户未登录").build());
        return list;
    }
}