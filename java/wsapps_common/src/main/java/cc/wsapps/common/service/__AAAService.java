package cc.wsapps.common.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cc.wsapps.common.entity.Module;
import cc.wsapps.common.example.ModuleExamplePage;
import cc.wsapps.common.mapper.ModuleMapper;
import cc.wsapps.framework.dao.Paginator;

@Controller
public class __AAAService {

	@Autowired
	private ModuleMapper moduleMapper;
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() throws JsonProcessingException {
		Module module =  moduleMapper.selectByPrimaryKey(1L);
		
		
		ModuleExamplePage example = new ModuleExamplePage();
		example.createCriteria().andCodeEqualTo(null).andIdLessThan(100L);
		Paginator paginator = new Paginator(1);
		example.setPaginator(paginator);
		System.out.println(paginator.getOffset() + "---" + paginator.getItemsPerPage());
		
		List<Module> list = moduleMapper.selectByExamplePage(example);
		//System.out.println(crmUser);
		//ObjectMapper mapper = new ObjectMapper();
		//System.out.println(mapper.writeValueAsString(crmUser));
		
		System.out.println(list);
		
		return module.toString();
	}
}


