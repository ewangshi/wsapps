package cc.wsapps.common.entity.base;

import java.io.Serializable;

public class BaseDictionaryValue implements Serializable {
    private Long id;

    private String code;

    private String key;

    private String value;

    private static final long serialVersionUID = 1043873628122900L;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", key=").append(key);
        sb.append(", value=").append(value);
        sb.append("]");
        return sb.toString();
    }
}