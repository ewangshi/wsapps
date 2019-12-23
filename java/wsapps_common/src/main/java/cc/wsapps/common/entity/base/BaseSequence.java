package cc.wsapps.common.entity.base;

import java.io.Serializable;

public class BaseSequence implements Serializable {
    private Long id;

    private String code;

    private String moduleCode;

    private Long min;

    private Long max;

    private Long current;

    private Integer cycle;

    private String prefix;

    private Integer length;

    private Integer padding;

    private String paddingchar;

    private Integer step;

    private Integer subscriptions;

    private static final long serialVersionUID = 1060304677808200L;

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

    public Long getMin() {
        return min;
    }

    public void setMin(Long min) {
        this.min = min;
    }

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(Long current) {
        this.current = current;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getPadding() {
        return padding;
    }

    public void setPadding(Integer padding) {
        this.padding = padding;
    }

    public String getPaddingchar() {
        return paddingchar;
    }

    public void setPaddingchar(String paddingchar) {
        this.paddingchar = paddingchar == null ? null : paddingchar.trim();
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Integer subscriptions) {
        this.subscriptions = subscriptions;
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
        sb.append(", min=").append(min);
        sb.append(", max=").append(max);
        sb.append(", current=").append(current);
        sb.append(", cycle=").append(cycle);
        sb.append(", prefix=").append(prefix);
        sb.append(", length=").append(length);
        sb.append(", padding=").append(padding);
        sb.append(", paddingchar=").append(paddingchar);
        sb.append(", step=").append(step);
        sb.append(", subscriptions=").append(subscriptions);
        sb.append("]");
        return sb.toString();
    }
}