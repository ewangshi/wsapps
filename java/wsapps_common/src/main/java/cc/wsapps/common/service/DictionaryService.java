package cc.wsapps.common.service;

import java.util.List;

import cc.wsapps.common.entity.Dictionary;
import cc.wsapps.common.entity.DictionaryValue;

public interface DictionaryService {

	Dictionary findOneByCode(String code);
	
	Dictionary findOneDtoByCode(String code);

	Dictionary findOneByCodeCacheRedis(String code);
	
	DictionaryValue findOneDicValByCodeAndKey(String code, String key);
	
	List<DictionaryValue> findDicValByCode(String code);


}
