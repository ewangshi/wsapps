package cc.wsapps.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.wsapps.common.config.ServletContextHolder;

public class CookieUtil {

	private final static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

	/**
	 * 获取 Cookie
	 */
	public static Cookie getCookieByName(String name) {
		HttpServletRequest request = ServletContextHolder.getHttpServletRequest();
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}
	
	public static Cookie getCookieByName(String name, HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}

	public static String getCookieValByName(String name) {
		String val = null;
		Cookie cookie = getCookieByName(name);
		if (null != cookie) {
			val = cookie.getValue();
			if (null != val) {
				try {
					val = URLEncoder.encode(val, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					logger.error("getCookieValByName error, name: " + name, e);
				}
			}
		}
		return val;
	}
	
	public static String getCookieValByName(String name, HttpServletRequest request) {
		String val = null;
		Cookie cookie = getCookieByName(name, request);
		if (null != cookie) {
			val = cookie.getValue();
			if (null != val) {
				try {
					val = URLEncoder.encode(val, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					logger.error("getCookieValByName error, name: " + name, e);
				}
			}
		}
		return val;
	}

	/**
	 * 删除cookie
	 */
	public static void removeCookieByName(String name) {
		HttpServletResponse response = ServletContextHolder.getHttpServletResponse();

		Cookie cookie = getCookieByName(name);
		if (cookie != null) {
			// 设置过期时间为立即。
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
	}
	
	public static void writeCookie2(String name, String value, String domain, String path, int expiry) {
		// 使用URL进行编码，避免写入cookie错误。
		try {
			Cookie cookie = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
			cookie.setDomain(domain);
			cookie.setPath(path);
			cookie.setMaxAge(expiry);
			writeCookie(cookie);
		} catch (Exception ex) {
			logger.error("Encode with URL error", ex);
		}
	}

	public static void writeCookie(String name, String value) {
		// 使用URL进行编码，避免写入cookie错误。
		try {
			writeCookie(new Cookie(name, URLEncoder.encode(value, "UTF-8")));
		} catch (Exception ex) {
			logger.error("Encode with URL error", ex);
		}
	}

	public static void writeCookie(Cookie cookie) {
		HttpServletResponse response = ServletContextHolder.getHttpServletResponse();
		// 使用URL进行编码，避免写入cookie错误。
		try {
			response.addCookie(cookie);
		} catch (Exception ex) {
			logger.error("Encode with URL error", ex);
		}
	}

}
