package cc.wsapps.sys.entity;

import cc.wsapps.sys.entity.base.BaseUser;
import java.io.Serializable;
import java.util.List;

public class User extends BaseUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Resource> resources;

	private List<Role> roles;

	private Organize organize;

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Organize getOrganize() {
		return organize;
	}

	public void setOrganize(Organize organize) {
		this.organize = organize;
	}

	@Override
	public String toString() {
		return "User [resources=" + resources + ", roles=" + roles + ", organize=" + organize + ", toString()="
				+ super.toString() + "]";
	}

}