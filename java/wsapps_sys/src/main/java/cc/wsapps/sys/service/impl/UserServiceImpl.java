package cc.wsapps.sys.service.impl;

import java.util.BitSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cc.wsapps.framework.dao.Paginator;
import cc.wsapps.sys.constant.LogicDelConstant;
import cc.wsapps.sys.entity.Resource;
import cc.wsapps.sys.entity.Role;
import cc.wsapps.sys.entity.User;
import cc.wsapps.sys.example.UserExample;
import cc.wsapps.sys.example.UserExamplePage;
import cc.wsapps.sys.mapper.UserMapper;
import cc.wsapps.sys.service.UserService;

@RestController
@RequestMapping("/sys/login/")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	@GetMapping("findByCode")
	public User findOneByCode(@RequestParam String code) {
		UserExample example = new UserExample();
		example.createCriteria().andCodeEqualTo(code).andIsDelEqualTo(LogicDelConstant.NORMAL);
		List<User> list = userMapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	@GetMapping("findByUserName")
	public User findOneByUserName(@RequestParam String userName) {
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(userName).andIsDelEqualTo(LogicDelConstant.NORMAL);
		List<User> list = userMapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	public List<User> findPage(User user, Paginator paginator) {
		UserExamplePage examplePage = new UserExamplePage();
		examplePage.setPaginator(paginator);
		examplePage.createCriteria().andEntityEqualTo(user);
		return userMapper.selectByExamplePage(examplePage);
	}

	@GetMapping("findRoleByCode")
	@Override
	public List<Role> findRoleByCode(String code) {
		return userMapper.selectRoleByCode(code);
	}

	@GetMapping("findResourceByCode")
	@Override
	public List<Resource> findResourceByCode(String code) {
		return userMapper.selectResourceByCode(code);
	}

	@GetMapping("findMenuByCode")
	@Override
	public List<Resource> findMenuByCode(String code) {
		return userMapper.selectdMenuByCode(code);
	}

	@GetMapping("findResourceBitSetByCode")
	@Override
	public String findResourceBitSetByCode(String code) {
		BitSet bitSet = null;
		List<Resource> resources = findResourceByCode(code);
		if (null != resources && resources.size() > 0) {
			Resource last = resources.get(resources.size() - 1);
			
			if (last.getId() > Integer.MAX_VALUE) {
				throw new RuntimeException("resources exceed the upper limit, id:" + last.getId());
			}
			
			bitSet = new BitSet(last.getId().intValue());
			
			for (Resource resource : resources) {
				bitSet.set(resource.getId().intValue(), true);
			}
		}
		return null == bitSet ? null : bitSet.toString();
	}

}
