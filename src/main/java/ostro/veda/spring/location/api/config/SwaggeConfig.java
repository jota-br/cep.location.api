@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contact() {
        return new Contact(
                "João Carlos Roveda Ostrovski",
                "https://github.com/jota-br",
                "ojcroveda@gmail.com");
    }
    private ApiInfoBuilder apiInfo() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Spring Location API");
        apiInfoBuilder.description("API RESTY with Spring");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Open Source");
        apiInfoBuilder.license("MIT");
        apiInfoBuilder.licenseUrl("https://github.com/jota-br");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;

    }
    @Bean
    public Docket apiDetail() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("ostro.veda.spring.location.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}