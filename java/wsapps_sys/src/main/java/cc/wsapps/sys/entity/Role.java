package cc.wsapps.sys.entity;

import java.io.Serializable;
import java.util.List;

import cc.wsapps.sys.entity.base.BaseRole;

public class Role extends BaseRole implements Serializable {
    private static final long serialVersionUID = 278492816340018L;
    
    private List<Resource> resources;

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "Role [resources=" + resources + ", toString()=" + super.toString() + "]";
	}
    
}