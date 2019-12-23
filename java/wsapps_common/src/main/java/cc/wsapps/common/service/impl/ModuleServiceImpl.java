package cc.wsapps.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cc.wsapps.common.entity.Module;
import cc.wsapps.common.example.ModuleExample;
import cc.wsapps.common.mapper.ModuleMapper;
import cc.wsapps.common.service.ModuleService;

@RestController
@RequestMapping("/ss/module/")
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	@GetMapping("findByCode")
	public Module findOneByCode(@RequestParam String code) {
		ModuleExample example = new ModuleExample();
		example.createCriteria().andCodeEqualTo(code);
		List<Module> list = moduleMapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	@GetMapping("findAll")
	public List<Module> findAll() {
		return moduleMapper.selectByExample(new ModuleExample());
	}

}
