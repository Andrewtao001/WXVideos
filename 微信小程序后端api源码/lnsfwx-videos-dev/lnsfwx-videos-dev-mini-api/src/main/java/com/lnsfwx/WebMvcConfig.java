package com.lnsfwx;

import com.lnsfwx.interceptor.WxInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                //导入静态资源swagger2
                .addResourceLocations("classpath:/META-INF/resources/")
               // .addResourceLocations("file:/opt/lnsf_mod_dev/");
        .addResourceLocations("file:C:/lnsf_mod_dev/");
    }
    @Bean
    public WxInterceptor wxInterceptor(){
        return  new WxInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( wxInterceptor()).addPathPatterns("/users/**")
                                                .addPathPatterns("/userVideo/upLoadVideos","/userVideo/upLoadCover")
        .excludePathPatterns("/users/queryPublisher").excludePathPatterns("/userbgm/uploadmp3");
        super.addInterceptors(registry);
    }
}
