package cc.wsapps.common.service;

import java.util.List;

import cc.wsapps.common.entity.Parameter;

public interface ParameterService {

	Parameter findOneByCode(String code);
	
	Parameter findOneByCodeCacheRedis(String code);
	
	List<Parameter> findByModuleCode(String moduleCode);
	
	void modifySelective(Parameter parameter);
}
