package cc.wsapps.startup.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@MapperScan("cc.wsapps.demo.mapper")
@SpringBootApplication
@ComponentScan({"cc.wsapps.startup.service", "cc.wsapps.sys.service", "cc.wsapps.sys.config"})
public class SpringbootSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSysApplication.class, args);
		
		
		
		//dto -> entity
		//mapperEx -> mapper ok
	}

}
