package fr.eli.lebar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"fr.eli.lebar"})
public class LeBar implements WebMvcConfigurer {

    public static void main (String[] args){

        SpringApplication.run(LeBar.class, args);
    }
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*") // toutes les entete HTTP sont autosiser
                .allowCredentials(true) // inclue les infos d'identification comme cookies
                .maxAge(3600); // 1h la duree max de la mise en cahe
    }

}
