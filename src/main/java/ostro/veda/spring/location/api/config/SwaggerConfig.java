//package ostro.veda.spring.location.api.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//
//@Configuration
//public class SwaggerConfig {
//    private Contact contact() {
//        return new Contact(
//                "João Carlos Roveda Ostrovski",
//                "https://github.com/jota-br",
//                "ojcroveda@gmail.com");
//    }
//    private ApiInfoBuilder apiInfo() {
//
//        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
//
//        apiInfoBuilder.title("Spring Location API");
//        apiInfoBuilder.description("API RESTY with Spring");
//        apiInfoBuilder.version("1.0");
//        apiInfoBuilder.termsOfServiceUrl("Open Source");
//        apiInfoBuilder.license("MIT");
//        apiInfoBuilder.licenseUrl("https://github.com/jota-br");
//        apiInfoBuilder.contact(this.contact());
//
//        return apiInfoBuilder;
//
//    }
//    @Bean
//    public Docket apiDetail() {
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//
//        docket
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("ostro.veda.spring.location.api.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(this.apiInfo().build())
//                .consumes(new HashSet<String>(List.of("application/json")))
//                .produces(new HashSet<String>(List.of("application/json")));
//
//        return docket;
//    }
//}