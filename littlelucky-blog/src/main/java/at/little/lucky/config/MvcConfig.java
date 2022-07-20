package at.little.lucky.config;

import at.little.lucky.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiaoChen
 * @description: AUTO GENERATION
 * @date 2022/7/16 14:32
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //虚拟映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        虚拟映射在这
        registry.addResourceHandler("/file/**").addResourceLocations("file:/opt/myblog/uploadFile/");
    }

    //    跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    //    拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
//                只拦截管理后台的请求
                .addPathPatterns("/admin/**");
    }


}
