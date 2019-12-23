package cc.wsapps.startup.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan({"cc.wsapps.common.config","cc.wsapps.common.service"})
public class CommonServiceStartup {

	public static void main(String[] args) {
		SpringApplication.run(CommonServiceStartup.class, args);
		
		
		
		//dto -> entity
		//mapperEx -> mapper ok
	}

}
