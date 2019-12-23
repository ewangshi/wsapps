package cc.wsapps.sys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cc.wsapps.sys.http.SysInterceptor;

@Configuration
@ComponentScan({"cc.wsapps.sys.http"})
public class SysHttpConfig implements WebMvcConfigurer {

	@Autowired
	private SysInterceptor sysInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sysInterceptor).addPathPatterns("/sys/**").excludePathPatterns("/sys/login/**");
		WebMvcConfigurer.super.addInterceptors(registry);
		
	}

	
}
