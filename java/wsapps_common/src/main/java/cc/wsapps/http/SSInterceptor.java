package cc.wsapps.http;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SSInterceptor extends HandlerInterceptorAdapter {

	@Value("${ss.md5str}")
    private String name;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = false;
		Enumeration<String> names = request.getParameterNames();
		List<String> list = new ArrayList<>();
		while (names.hasMoreElements()) {
			String string = names.nextElement();
			list.add(string);
		}
		//ascByBirthdayList
		list.stream().sorted().collect(Collectors.toList());
		StringBuffer buffer = new StringBuffer(name);
		list.forEach((name) -> {
			buffer.append(":").append(request.getParameter(name));
	    });
		
		String md5 = DigestUtils.md5DigestAsHex(buffer.toString().getBytes());
		
		String token = request.getHeader(HttpConstant.HEADER_KEY_SS_TOKEN);
		
		if (null != token && token.equalsIgnoreCase(md5)) {
			flag = super.preHandle(request, response, handler);
		} else {
			flag = false;
		}
		
		return flag;
	}
	
	

}
