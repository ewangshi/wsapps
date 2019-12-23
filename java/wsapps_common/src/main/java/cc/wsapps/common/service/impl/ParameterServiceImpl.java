package cc.wsapps.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cc.wsapps.common.entity.Parameter;
import cc.wsapps.common.example.ParameterExample;
import cc.wsapps.common.mapper.ParameterMapper;
import cc.wsapps.common.service.ParameterService;

@RestController
@RequestMapping("/ss/parameter/")
public class ParameterServiceImpl implements ParameterService {

	@Autowired
	private ParameterMapper parameterMapper;
	
	@Override
	@GetMapping("findByCode")
	public Parameter findOneByCode(@RequestParam String code) {
		ParameterExample example = new ParameterExample();
		example.createCriteria().andCodeEqualTo(code);
		List<Parameter> list = parameterMapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	@GetMapping("findByCodeCacheRedis")
	public Parameter findOneByCodeCacheRedis(@RequestParam String code) {
		return findOneByCode(code);
	}

	@Override
	@GetMapping("queryByModuleCode")
	public List<Parameter> findByModuleCode(@RequestParam String moduleCode) {
		ParameterExample example = new ParameterExample();
		example.createCriteria().andModuleCodeEqualTo(moduleCode);
		return parameterMapper.selectByExample(example);
	}

	@Override
	@PostMapping("modifySelective")
	public void modifySelective(@RequestParam Parameter parameter) {
		parameterMapper.updateByPrimaryKeySelective(parameter);
	}


}
