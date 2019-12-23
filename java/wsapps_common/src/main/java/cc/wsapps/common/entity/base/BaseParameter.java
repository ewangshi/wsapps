package cc.wsapps.common.entity.base;

import java.io.Serializable;

public class BaseParameter implements Serializable {
    private Long id;

    private String code;

    private String moduleCode;

    private String name;

    private String value;

    private String description;

    private static final long serialVersionUID = 1043873625951100L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", moduleCode=").append(moduleCode);
        sb.append(", name=").append(name);
        sb.append(", value=").append(value);
        sb.append(", description=").append(description);
        sb.append("]");
        return sb.toString();
    }
}