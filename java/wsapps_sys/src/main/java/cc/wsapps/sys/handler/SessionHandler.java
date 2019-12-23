package cc.wsapps.sys.handler;

import org.springframework.util.StringUtils;

import cc.wsapps.handler.RedisHandler;
import cc.wsapps.sys.security.Authorization;

public class SessionHandler {

	private RedisHandler sysRedisHandler;
	
	public SessionHandler(RedisHandler sysRedisHandler) {
		super();
		this.sysRedisHandler = sysRedisHandler;
	}

	private static final String SESSION_PREFIX = "session_";
	private static final String SESSION_AUTH_KEY = "auth";
	
	public void create(Authorization authorization) {
		push(authorization, SESSION_AUTH_KEY, authorization);
	}
	
	public void push(Authorization authorization, String key, Object value) {
		if (null != authorization && null != authorization.getSession() && null != authorization.getId()
				&& !StringUtils.isEmpty(key) && null != value) {
			String sessionId = SESSION_PREFIX + authorization.getSession();
			sysRedisHandler.getObjectRedisTemplate().opsForHash().put(sessionId, key, value);
		} else {
			throw new RuntimeException("Entry is empty,auth:" + authorization + ",key:" + key + ",value:" + value);
		}
	}
	
	public Object get(String sessionId, String key) {
		String session = SESSION_PREFIX + sessionId;
		return sysRedisHandler.getObjectRedisTemplate().opsForHash().get(session, key);
	}
	
	public Authorization getAuthorization(String sessionId) {
		String session = SESSION_PREFIX + sessionId;
		return (Authorization) sysRedisHandler.getObjectRedisTemplate().opsForHash().get(session, SESSION_AUTH_KEY);
	}
	
}
