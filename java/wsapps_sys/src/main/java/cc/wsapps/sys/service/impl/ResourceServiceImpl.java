package cc.wsapps.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cc.wsapps.framework.dao.Paginator;
import cc.wsapps.sys.constant.LogicDelConstant;
import cc.wsapps.sys.entity.Resource;
import cc.wsapps.sys.example.ResourceExample;
import cc.wsapps.sys.example.ResourceExamplePage;
import cc.wsapps.sys.mapper.ResourceMapper;
import cc.wsapps.sys.service.ResourceService;

public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper mapper;
	
	@Override
	public Resource findOneByCode(String code) {
		ResourceExample example = new ResourceExample();
		example.createCriteria().andCodeEqualTo(code).andIsDelEqualTo(LogicDelConstant.NORMAL);
		List<Resource> list = mapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	public Resource findOneByName(String name) {
		ResourceExample example = new ResourceExample();
		example.createCriteria().andNameEqualTo(name).andIsDelEqualTo(LogicDelConstant.NORMAL);
		List<Resource> list = mapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	public List<Resource> findPage(Resource resource, Paginator paginator) {
		ResourceExamplePage example = new ResourceExamplePage();
		example.setPaginator(paginator);
		example.createCriteria().andEntityEqualTo(resource);
		return mapper.selectByExamplePage(example);
	}

	@Override
	public List<Resource> findByModuleCode(String moduleCode) {
		ResourceExample example = new ResourceExample();
		example.createCriteria().andModuleCodeEqualTo(moduleCode).andIsDelEqualTo(LogicDelConstant.NORMAL);
		return mapper.selectByExample(example);
	}

}
