package sono_light_reservation.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Profile("development")
@EnableWebMvc
public class DevCorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("http://localhost:9000/**")
                .allowedOrigins("http://localhost:4200/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
