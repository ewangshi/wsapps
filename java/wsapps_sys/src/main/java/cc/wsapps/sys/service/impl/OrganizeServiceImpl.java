package cc.wsapps.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cc.wsapps.framework.dao.Paginator;
import cc.wsapps.sys.constant.LogicDelConstant;
import cc.wsapps.sys.constant.OrganizeStatusConstant;
import cc.wsapps.sys.entity.Organize;
import cc.wsapps.sys.example.OrganizeExample;
import cc.wsapps.sys.example.OrganizeExamplePage;
import cc.wsapps.sys.mapper.OrganizeMapper;
import cc.wsapps.sys.service.OrganizeService;

public class OrganizeServiceImpl implements OrganizeService {

	@Autowired
	private OrganizeMapper mapper;
	
	@Override
	public Organize findOneByCode(String code) {
		OrganizeExample example = new OrganizeExample();
		example.createCriteria().andCodeEqualTo(code).andIsDelEqualTo(LogicDelConstant.NORMAL);
		List<Organize> list = mapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	public Organize findOneByName(String name) {
		OrganizeExample example = new OrganizeExample();
		example.createCriteria().andNameEqualTo(name).andIsDelEqualTo(LogicDelConstant.NORMAL);
		List<Organize> list = mapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	public List<Organize> findByPath(String path) {
		OrganizeExample example = new OrganizeExample();
		example.createCriteria().andCodePathEqualTo(path).andIsDelEqualTo(LogicDelConstant.NORMAL);
		return mapper.selectByExample(example);
	}

	@Override
	public List<Organize> findByPathStartingWith(String path) {
		OrganizeExample example = new OrganizeExample();
		example.createCriteria().andCodePathLike(path + "%")
			.andStatusEqualTo(OrganizeStatusConstant.ENABLE)
			.andIsDelEqualTo(LogicDelConstant.NORMAL);
		return mapper.selectByExample(example);
	}
	
	@Override
	public List<Organize> findPage(Organize organize, Paginator paginator) {
		OrganizeExamplePage example = new OrganizeExamplePage();
		example.setPaginator(paginator);
		example.createCriteria().andEntityEqualTo(organize);
		return mapper.selectByExamplePage(example);
	}

	@Override
	public void enable(String code) {
		modifyStatus(code, -1, OrganizeStatusConstant.ENABLE);
	}

	@Override
	public void disable(String code) {
		modifyStatus(code, -1, OrganizeStatusConstant.DISABLE);
	}
	
	private void modifyStatus(String code, int updater, int status) {
		OrganizeExample example = new OrganizeExample();
		example.createCriteria().andCodeEqualTo(code).andIsDelEqualTo(LogicDelConstant.NORMAL);
		Organize record = new Organize();
		record.setStatus(status);
		record.setUpdatedDate(new Date());
		record.setUpdater(updater);
		mapper.updateByExampleSelective(record, example);
	}
}
