package fushuai.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class Myconfig {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver i=new InternalResourceViewResolver();
        i.setPrefix("/WEB-INF/pages/");
        i.setSuffix(".jsp");
        return  i;
    }
    @Bean
    public MultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
