package cc.wsapps.sys.security;

import java.io.Serializable;

public class Authorization implements Serializable {

	private static final long serialVersionUID = 2903748234792873l;

	// 用户ID
	private Long id;
	// 用户名
	private String username;
	// 用户名姓名
	private String name;
	// 会话标识
	private String session;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Authorization [id=" + id + ", username=" + username + ", name=" + name + ", session=" + session + "]";
	}
}
