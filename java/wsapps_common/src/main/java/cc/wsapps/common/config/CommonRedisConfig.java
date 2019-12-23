package cc.wsapps.common.config;

import java.time.Duration;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;

import cc.wsapps.handler.RedisHandler;
import cc.wsapps.redis.ObjectRedisTemplate;

@Configuration
public class CommonRedisConfig {
	
	@Autowired
	private CommonRedisProperties properties;
	
	@Bean("commonRedisHandler")
	public RedisHandler commonRedisHandler() {
		return new RedisHandler(commonObjectRedisTemplate());
	}
	
	@Bean("commonObjectRedisTemplate")
	public ObjectRedisTemplate commonObjectRedisTemplate() {
		  return new ObjectRedisTemplate(commonRedisConnectionFactory());
	}
	
	private LettuceConnectionFactory commonRedisConnectionFactory() {
		
		@SuppressWarnings("rawtypes")
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		poolConfig.setMaxIdle(properties.getMaxTotal());
		poolConfig.setMaxIdle(properties.getMaxIdle());
		poolConfig.setMinIdle(properties.getMinIdle());
		poolConfig.setMaxWaitMillis(properties.getMaxWaitMillis());
		poolConfig.setTestOnBorrow(properties.getTestOnBorrow());
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
        builder.poolConfig(poolConfig);
        builder.commandTimeout(Duration.ofSeconds(60));
        builder.shutdownTimeout(Duration.ofMillis(properties.getTimeout()));
		
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(properties.getHost(),properties.getPort());
		LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration, builder.build());
		factory.setDatabase(properties.getDatabase());
		factory.afterPropertiesSet();
		return factory;
	}
	
}

@Configuration
@ConfigurationProperties(prefix = "spring.redis.common")
class CommonRedisProperties {
	private Integer maxIdle;
	private Integer minIdle;
	private Integer maxTotal;
	private Long maxWaitMillis;
	private Boolean testOnBorrow;
	private Integer timeout;
	private Integer database;
	private String host;
	private Integer port;
	
	public Integer getMaxIdle() {
		return maxIdle;
	}
	public Integer getMinIdle() {
		return minIdle;
	}
	public Integer getMaxTotal() {
		return maxTotal;
	}
	public Long getMaxWaitMillis() {
		return maxWaitMillis;
	}
	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public Integer getDatabase() {
		return database;
	}
	public String getHost() {
		return host;
	}
	public Integer getPort() {
		return port;
	}
	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}
	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}
	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}
	public void setMaxWaitMillis(Long maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}
	public void setTestOnBorrow(Boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public void setDatabase(Integer database) {
		this.database = database;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
}