package cc.wsapps.sys.mapper;

import cc.wsapps.framework.dao.BaseMapper;
import cc.wsapps.sys.entity.Role;
import cc.wsapps.sys.example.RoleExample;
import cc.wsapps.sys.example.RoleExamplePage;

public interface RoleMapper extends BaseMapper<RoleExample, RoleExamplePage, Role> {
	Role selectDetailByCode(String code);
}