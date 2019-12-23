package cc.wsapps.startup.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan({"cc.wsapps.common.config","cc.wsapps.common.service"})
public class SpringbootCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCommonApplication.class, args);
	}

}
