package cc.wsapps.common.service;

import java.util.List;

import cc.wsapps.common.entity.Module;

public interface ModuleService {

	Module findOneByCode(String code);
	
	List<Module> findAll();
}
