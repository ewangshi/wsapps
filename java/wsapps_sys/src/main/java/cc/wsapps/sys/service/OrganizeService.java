package cc.wsapps.sys.service;

import java.util.List;

import cc.wsapps.framework.dao.Paginator;
import cc.wsapps.sys.entity.Organize;

public interface OrganizeService {

	/**
	 * 编码查询组织机构
	 * @param code 组织机构编码
	 * @return 组织机构
	 */
	Organize findOneByCode(String code);

	/**
	 * 名称查询组织机构
	 * @param na名称me 组织机构
	 * @return 组织机构
	 */
	Organize findOneByName(String name);

	List<Organize> findPage(Organize organize, Paginator paginator);
	
	/**
	 * path查询组织机构
	 * @param path 组织机构path
	 * @return 组织机构列表
	 */
	List<Organize> findByPath(String path);
	
	/**
	 * path右like查询组织机构
	 * @param path 组织机构path
	 * @return 组织机构列表
	 */
	List<Organize> findByPathStartingWith(String path);
	
	/**
	 * 启用
	 * @param code 组织机构编码
	 */
	void enable(String code);
	
	/**
	 * 禁用
	 * @param code 组织机构编码
	 */
	void disable(String code);
}
