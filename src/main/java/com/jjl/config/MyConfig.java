package com.jjl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//扩展Springmvc mvc配置
@Configuration

public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登陆页面不能拦截，静态资源不能拦截，登陆到主页面也是不能拦截的
        registry.addInterceptor(new LoginIntercettor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html"
                        ,"/"
                        ,"/user/login"
                        , "/static/**"
                        ,"../static/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index1").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        //这里接受的是controller返回的main来让域名不太丑
        registry.addViewController("/main.html").setViewName("dashboard");
    }
    //必须放到bean里面 方法名必须要是这个不然不会生效的
    @Bean
    public MylocalResovler localeResolver(){
        return new MylocalResovler();
    }


   /* @Bean
    public ViewResolver myViewResolver (){
        return new MyViewResolver();
    }
    public static  class  MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
*/

}
