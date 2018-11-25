package com.frame.util;

import java.util.Locale;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhanglm
 * @date 2018年11月22日 下午2:17:10
 * 自定义拦截器
 * 定义区域解析器
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Slf4j
public class LocaleConfig implements WebMvcConfigurer{

	@Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setCookieName("localeCookie");
        //设置默认区域
        localeResolver.setDefaultLocale(Locale.CHINA);
        localeResolver.setCookieMaxAge(3600);//设置cookie有效期.
        return localeResolver;
    }
	
	
	   @Bean
	    public LocaleChangeInterceptor localeChangeInterceptor() {
	        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	        // 参数名
	        log.info("设置语言参数名");
	        lci.setParamName("lang");
	        return lci;
	    }
	   
	   @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(localeChangeInterceptor());
	    }


	
}
