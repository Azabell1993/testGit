package com.azabellcode.blog;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
	/*
	 * @HTML Request Mapping
	 * 
	 * @classpath:/templates/, classpath:/static/
	 * 
	 * @Azabell1993
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**")
				.addResourceLocations(
						"classpath:/webapp/WEB-INF/",
						"classpath:/templates/",
						"classpath:/templates/thymeleaf/",
						"classpath:/templates/thymeleaf/**/",
						"classpath:/templates/thymeleaf/assets/",
						"classpath:/templates/thymeleaf/assets/css/",
						"classpath:/templates/thymeleaf/assets/js/",
						"classpath:/templates/thymeleaf/assets/wasm/",
						"classpath:/templates/thymeleaf/main",
						"classpath:/templates/thymeleaf/main/**/",
						"classpath:/templates/thymeleaf/fragments/",
						"classpath:/templates/thymeleaf/fragments/**/")
				.setCacheControl(CacheControl.maxAge(50, TimeUnit.MINUTES));
	}

}