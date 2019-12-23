package cc.wsapps.handler;

import java.util.concurrent.TimeUnit;

import cc.wsapps.redis.ObjectRedisTemplate;

public class RedisHandler {

	public RedisHandler(ObjectRedisTemplate objectRedisTemplate) {
		this.objectRedisTemplate = objectRedisTemplate;
	}

	private ObjectRedisTemplate objectRedisTemplate;

	private int defaultExp = 60 * 30;

	public void set(String key, Object value, int exp) {
		objectRedisTemplate.opsForValue().set(key, value, exp, TimeUnit.SECONDS);
	}

	public void set(String key, Object value) {
		set(key, value, defaultExp);
	}
	
	public Object get(String key) {
		return objectRedisTemplate.opsForValue().get(key);
	}
	

	public void delete(String key) {
		objectRedisTemplate.delete(key);
	}

	public ObjectRedisTemplate getObjectRedisTemplate() {
		return objectRedisTemplate;
	}
	
}
