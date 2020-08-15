package com.example.family.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
@ApiModel(value="UserInfo对象", description="")
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer userFdId;

    private String userName;

    private String userPhone;

    private String userPass;

    private String userImage;

    private Integer userType;

    private LocalDateTime updateTime;

    private Integer updatorId;

    private Integer isDelete;

    public Integer getUserFdId() {
        return userFdId;
    }

    public void setUserFdId(Integer userFdId) {
        this.userFdId = userFdId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdatorId() {
        return updatorId;
    }

    public void setUpdatorId(Integer updatorId) {
        this.updatorId = updatorId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
