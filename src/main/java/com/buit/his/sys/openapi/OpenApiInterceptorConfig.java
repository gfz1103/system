package com.buit.his.sys.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author sunjx
 * @Date 2020-12-15 11:09
 * @Description OPENAPI 拦截器
 **/
@Configuration
public class OpenApiInterceptorConfig implements WebMvcConfigurer {

	@Bean
	public OpenApiInterceptor openApiInterceptor() {
		return new OpenApiInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(openApiInterceptor()).addPathPatterns("/**");
	}

}
