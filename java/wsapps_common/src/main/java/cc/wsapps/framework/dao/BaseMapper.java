package cc.wsapps.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<Example, ExamplePage, E> {
	long countByExample(Example example);

	int deleteByExample(Example example);

	int deleteByPrimaryKey(Long id);

	int insert(E record);

	int insertSelective(E record);

	List<E> selectByExample(Example example);

	E selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") E record, @Param("example") Example example);

	int updateByExample(@Param("record") E record, @Param("example") Example example);

	int updateByPrimaryKeySelective(E record);

	int updateByPrimaryKey(E record);
	
	List<E> selectByExamplePage(ExamplePage example);

}
