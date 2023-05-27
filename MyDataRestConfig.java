//package com.petproject1.daxi.config;
//
//import com.petproject1.daxi.domain.Note;
//import com.petproject1.daxi.domain.User;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//
//@Configuration
//public class MyDataRestConfig implements RepositoryRestConfigurer {
//
//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//        cors.addMapping("/**")
//                .allowedOrigins("http://localhost:4200")
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("*");
//
//        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
//
//        config.getExposureConfiguration()
//                .forDomainType(Note.class)
//                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
//                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
//
//        config.getExposureConfiguration()
//                .forDomainType(User.class)
//                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
//                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
//
//    }
//}
