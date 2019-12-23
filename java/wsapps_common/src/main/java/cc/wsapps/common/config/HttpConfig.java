package cc.wsapps.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cc.wsapps.http.SSInterceptor;

@Configuration
@ComponentScan({"cc.wsapps.http"})
public class HttpConfig implements WebMvcConfigurer {

	@Autowired
	private SSInterceptor ssInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(ssInterceptor).addPathPatterns("/ss/**");
		WebMvcConfigurer.super.addInterceptors(registry);
		
	}

	
}
