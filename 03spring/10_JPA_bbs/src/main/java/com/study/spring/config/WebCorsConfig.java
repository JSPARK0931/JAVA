package com.study.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//톰캣실행시 제일먼저 읽음
@Configuration
public class WebCorsConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
				.allowedOriginPatterns("*") //webpage size 넣는곳 "http://localhost:5173"
				.allowedMethods("GET","POST","PUT","DELETE")
				.allowedHeaders("Content-Type", "Authorization")	
				.exposedHeaders("Location").allowCredentials(true)
                .maxAge(3600);
		
	}
	
	

}
