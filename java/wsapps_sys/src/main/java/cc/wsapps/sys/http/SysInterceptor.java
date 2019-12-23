package cc.wsapps.sys.http;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cc.wsapps.sys.constant.AuthorizationConstant;
import cc.wsapps.sys.handler.SessionHandler;
import cc.wsapps.sys.security.Authorization;
import cc.wsapps.util.CookieUtil;

@Component
public class SysInterceptor extends HandlerInterceptorAdapter {

	@Resource(name = "sysSessionHandler")
	private SessionHandler sysSessionHandler;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = false;
		Authorization hAuthorization = headerToAuth(request);
		Authorization cAuthorization = cookieToAuth(request);
		Authorization authorization = null != hAuthorization ? hAuthorization : cAuthorization;
		
		Authorization auth = sysSessionHandler.getAuthorization(authorization.getSession());
		if (null != auth && auth.getId() == authorization.getId()) {
			flag = true;
		}
		
		return flag;
	}
	
	private Authorization headerToAuth(HttpServletRequest request) {
		Authorization authorization = null;
		String session = request.getHeader(AuthorizationConstant.KEY_SESSION);
		String id = request.getHeader(AuthorizationConstant.KEY_ID);
		
		if (StringUtils.isEmpty(session) || StringUtils.isEmpty(id)) {
			
		} else {
			String name = request.getHeader(AuthorizationConstant.KEY_NAME);
			String username = request.getHeader(AuthorizationConstant.KEY_USERNAME);
			
			authorization = new Authorization();
			authorization.setId(null != id ? Long.valueOf(id) : null);
			authorization.setName(name);
			authorization.setSession(session);
			authorization.setUsername(username);
		}
		
		return authorization;
	}
	
	private Authorization cookieToAuth(HttpServletRequest request) {
		Authorization authorization = null;
		String session = CookieUtil.getCookieValByName(AuthorizationConstant.KEY_SESSION, request);
		String id = CookieUtil.getCookieValByName(AuthorizationConstant.KEY_ID, request);
		
		if (StringUtils.isEmpty(session) || StringUtils.isEmpty(id)) {
			
		} else {
			String name = CookieUtil.getCookieValByName(AuthorizationConstant.KEY_NAME, request);
			String username = CookieUtil.getCookieValByName(AuthorizationConstant.KEY_USERNAME, request);
			
			authorization = new Authorization();
			authorization.setId(null != id ? Long.valueOf(id) : null);
			authorization.setName(name);
			authorization.setSession(session);
			authorization.setUsername(username);
		}
		
		return authorization;
	}
	

}
