package cc.wsapps.sys.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cc.wsapps.handler.RedisHandler;
import cc.wsapps.sys.handler.SessionHandler;

@Configuration
public class SessionConfig {

	@Bean("sysSessionHandler")
	public SessionHandler sysSessionHandler(@Qualifier("sysRedisHandler") RedisHandler sysRedisHandler) {
		return new SessionHandler(sysRedisHandler);
	}
}
