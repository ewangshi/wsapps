package cc.wsapps.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.wsapps.framework.dao.Paginator;
import cc.wsapps.sys.constant.LogicDelConstant;
import cc.wsapps.sys.constant.RoleStatusConstant;
import cc.wsapps.sys.entity.Role;
import cc.wsapps.sys.example.RoleExample;
import cc.wsapps.sys.example.RoleExamplePage;
import cc.wsapps.sys.mapper.RoleMapper;
import cc.wsapps.sys.service.RoleService;

@RestController
@RequestMapping("/sys/login/")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper mapper;
	
	@Override
	public Role findOneByCode(String code) {
		RoleExample example = new RoleExample();
		example.createCriteria().andCodeEqualTo(code).andIsDelEqualTo(LogicDelConstant.NORMAL);
		List<Role> list = mapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	public Role findOneByName(String name) {
		RoleExample example = new RoleExample();
		example.createCriteria().andNameEqualTo(name).andIsDelEqualTo(LogicDelConstant.NORMAL);
		List<Role> list = mapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}
	
	@Override
	public Role findOneEnableByCode(String code) {
		RoleExample example = new RoleExample();
		example.createCriteria().andCodeEqualTo(code).andIsDelEqualTo(LogicDelConstant.NORMAL)
			.andStatusEqualTo(RoleStatusConstant.ENABLE);
		List<Role> list = mapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	public Role findOneEnableByName(String name) {
		RoleExample example = new RoleExample();
		example.createCriteria().andNameEqualTo(name).andIsDelEqualTo(LogicDelConstant.NORMAL)
			.andStatusEqualTo(RoleStatusConstant.ENABLE);
		List<Role> list = mapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}


	@Override
	public List<Role> findPage(Role role, Paginator paginator) {
		RoleExamplePage example = new RoleExamplePage();
		example.setPaginator(paginator);
		example.createCriteria().andEntityEqualTo(role);
		return mapper.selectByExamplePage(example);
	}

	@Override
	public void enable(String code) {
		modifyStatus(code, -1, RoleStatusConstant.ENABLE);
	}

	@Override
	public void disable(String code) {
		modifyStatus(code, -1, RoleStatusConstant.DISABLE);
	}
	
	private void modifyStatus(String code, int updater, int status) {
		RoleExample example = new RoleExample();
		example.createCriteria().andCodeEqualTo(code).andIsDelEqualTo(LogicDelConstant.NORMAL);
		Role record = new Role();
		record.setStatus(status);
		record.setUpdatedDate(new Date());
		record.setUpdater(updater);
		mapper.updateByExampleSelective(record, example);
	}

	@GetMapping("findDetailByCode")
	@Override
	public Role findDetailByCode(String code) {
		Role role = mapper.selectDetailByCode(code);
		return role;
	}

}
