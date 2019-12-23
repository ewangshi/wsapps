package cc.wsapps.sys.service;

import java.util.List;

import cc.wsapps.framework.dao.Paginator;
import cc.wsapps.sys.entity.Resource;

public interface ResourceService {

	Resource findOneByCode(String code);

	Resource findOneByName(String name);

	List<Resource> findPage(Resource resource, Paginator paginator);
	
	List<Resource> findByModuleCode(String moduleCode);
}
