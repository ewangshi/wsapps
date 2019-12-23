package cc.wsapps.sys.service;

import java.util.List;

import cc.wsapps.framework.dao.Paginator;
import cc.wsapps.sys.entity.Resource;
import cc.wsapps.sys.entity.Role;
import cc.wsapps.sys.entity.User;

public interface UserService {

	User findOneByCode(String code);
	
	User findOneByUserName(String userName);
	
	List<User> findPage(User user, Paginator paginator);
	
	List<Role> findRoleByCode(String code);
	
	List<Resource> findResourceByCode(String code);
	
	String findResourceBitSetByCode(String code);
	
	List<Resource> findMenuByCode(String code);
}
