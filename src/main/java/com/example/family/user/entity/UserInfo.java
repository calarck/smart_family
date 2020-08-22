package com.example.family.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author calarck
 * @since 2020-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserInfo对象", description="")
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    private Long userFdId;

    private String userName;

    private String userPhone;

    private String userPass;

    private String userImage;

    private Integer userType;

    private LocalDateTime updateTime;

    private Integer updatorId;

    private Integer isDelete;


}
