package com.fushuai.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("com.fushuai.controller")
@EnableWebMvc //启用mvc注解和一些其他组件
public class SpringMvcConfig implements WebMvcConfigurer{

    //消息转换器
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
           //fastJson版本高带来的问题的解决方案
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        converters.add(fastJsonHttpMessageConverter);
    }

    //FreeMarker配置
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/");
        return freeMarkerConfigurer;
    }


    //视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setSuffix(".html");
        freeMarkerViewResolver.setContentType("text/html;charset=utf-8");
        freeMarkerViewResolver.setViewClass(FreeMarkerView.class);

        //InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        //internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        //internalResourceViewResolver.setSuffix(".jsp");
        //internalResourceViewResolver.setViewClass(JstlView.class);

        registry.viewResolver(freeMarkerViewResolver);
        //registry.viewResolver(internalResourceViewResolver);
    }

    //静态资源处理
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**")
                .addResourceLocations("/js/");

        registry.addResourceHandler("/css/**")
                .addResourceLocations("/css/");

        registry.addResourceHandler("/imgs/**")
                .addResourceLocations("/imgs/");
    }

    //视图访问控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/add")
        //        .setViewName("add");
        //
        //registry.addViewController("/detail")
        //        .setViewName("detail");
    }

    //文件解析器
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }
}
