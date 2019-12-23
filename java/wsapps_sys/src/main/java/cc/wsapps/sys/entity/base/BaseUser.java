package cc.wsapps.sys.entity.base;

import java.io.Serializable;
import java.util.Date;

public class BaseUser implements Serializable {
    private Long id;

    private String code;

    private String userName;

    private String name;

    private String nickname;

    private String email;

    private String mobile;

    private String orgPath;

    private Integer status;

    private Integer creater;

    private Date createdDate;

    private Integer updater;

    private Date updatedDate;

    private Integer isDel;

    private static final long serialVersionUID = 1L;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath == null ? null : orgPath.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdater() {
        return updater;
    }

    public void setUpdater(Integer updater) {
        this.updater = updater;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", userName=").append(userName);
        sb.append(", name=").append(name);
        sb.append(", nickname=").append(nickname);
        sb.append(", email=").append(email);
        sb.append(", mobile=").append(mobile);
        sb.append(", orgPath=").append(orgPath);
        sb.append(", status=").append(status);
        sb.append(", creater=").append(creater);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updater=").append(updater);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}