package fokka.se.meetingbackend.CFG;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Swagger implements WebMvcConfigurer {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI().
                info(new Info().
                        title("Calendar API").
                        description("Calendar Backend Application API Documentation").
                        version("1.0.0").
                        license(new License().
                                name("Apache 2.0").
                                url("http://springdoc.org")));


    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings (CorsRegistry registry){
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
