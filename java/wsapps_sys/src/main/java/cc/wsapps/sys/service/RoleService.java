package cc.wsapps.sys.service;

import java.util.List;

import cc.wsapps.framework.dao.Paginator;
import cc.wsapps.sys.entity.Role;

public interface RoleService {

	Role findOneByCode(String code);

	Role findOneByName(String name);
	
	Role findOneEnableByCode(String code);

	Role findOneEnableByName(String name);

	List<Role> findPage(Role role, Paginator paginator);
	
	/**
	 * 启用
	 * @param code 角色编码
	 */
	void enable(String code);
	
	/**
	 * 禁用
	 * @param code 角色编码
	 */
	void disable(String code);
	
	Role findDetailByCode(String code);
}
