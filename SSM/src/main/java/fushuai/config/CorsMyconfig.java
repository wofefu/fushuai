package fushuai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 支持跨域配置  相当于springMVC项目中的mv：cros xml配置
 */
@Configuration
public class CorsMyconfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        //匿名类方式
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
