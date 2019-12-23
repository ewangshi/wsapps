package cc.wsapps.common.entity;

import cc.wsapps.common.entity.base.BaseDictionary;
import java.io.Serializable;
import java.util.List;

public class Dictionary extends BaseDictionary implements Serializable {
	private static final long serialVersionUID = 1043873626980600L;
	
	private List<DictionaryValue> dictionaryValueList;

	public List<DictionaryValue> getDictionaryValueList() {
		return dictionaryValueList;
	}

	public void setDictionaryValueList(List<DictionaryValue> dictionaryValueList) {
		this.dictionaryValueList = dictionaryValueList;
	}

	@Override
	public String toString() {
		return "Dictionary [dictionaryValueList=" + dictionaryValueList + ", getId()=" + getId() + ", getCode()="
				+ getCode() + ", getModuleCode()=" + getModuleCode() + ", getName()=" + getName()
				+ ", getDescription()=" + getDescription() + "]";
	}
	
	

}