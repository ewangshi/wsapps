package cc.wsapps.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cc.wsapps.common.entity.Dictionary;
import cc.wsapps.common.entity.DictionaryValue;
import cc.wsapps.common.example.DictionaryExample;
import cc.wsapps.common.example.DictionaryValueExample;
import cc.wsapps.common.mapper.DictionaryMapper;
import cc.wsapps.common.mapper.DictionaryValueMapper;
import cc.wsapps.common.service.DictionaryService;

@RequestMapping("/ss/dictionary/")
public class DictionaryServiceimpl implements DictionaryService {

	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Autowired
	private DictionaryValueMapper dictionaryValueMapper;
	
	@Override
	@GetMapping("findByCode")
	public Dictionary findOneByCode(@RequestParam String code) {
		DictionaryExample example = new DictionaryExample();
		example.createCriteria().andCodeEqualTo(code);
		List<Dictionary> list = dictionaryMapper.selectByExample(example);
		return null != list ? list.get(0) : null;
		
	}

	@Override
	@GetMapping("findByCodeCacheRedis")
	public Dictionary findOneByCodeCacheRedis(@RequestParam String code) {
		return findOneDtoByCode(code);
	}

	@Override
	@GetMapping("findDtoByCode")
	public Dictionary findOneDtoByCode(@RequestParam String code) {
		Dictionary dictionary = findOneByCode(code);
		if (null != dictionary) {
			List<DictionaryValue> values = findDicValByCode(code);
			dictionary.setDictionaryValueList(values);
		}
		return dictionary;
	}

	@Override
	@GetMapping("findDicValByCodeAndKey")
	public DictionaryValue findOneDicValByCodeAndKey(@RequestParam String code, @RequestParam String key) {
		DictionaryValueExample example = new DictionaryValueExample();
		example.createCriteria().andCodeEqualTo(code).andKeyEqualTo(key);
		List<DictionaryValue> list = dictionaryValueMapper.selectByExample(example);
		return null != list ? list.get(0) : null;
	}

	@Override
	@GetMapping("queryDicValByCode")
	public List<DictionaryValue> findDicValByCode(@RequestParam String code) {
		DictionaryValueExample example = new DictionaryValueExample();
		example.createCriteria().andCodeEqualTo(code);
		return dictionaryValueMapper.selectByExample(example);
	}

}
