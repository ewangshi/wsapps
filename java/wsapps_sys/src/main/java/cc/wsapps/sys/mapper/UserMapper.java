package cc.wsapps.sys.mapper;

import java.util.List;

import cc.wsapps.framework.dao.BaseMapper;
import cc.wsapps.sys.entity.Resource;
import cc.wsapps.sys.entity.Role;
import cc.wsapps.sys.entity.User;
import cc.wsapps.sys.example.UserExample;
import cc.wsapps.sys.example.UserExamplePage;

public interface UserMapper extends BaseMapper<UserExample, UserExamplePage, User> {
	
	List<Role> selectRoleByCode(String code);
	
	List<Resource> selectResourceByCode(String code);
	
	List<Resource> selectdMenuByCode(String code);
}