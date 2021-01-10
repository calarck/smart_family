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
@ApiModel(value="UserType对象", description="")
public class UserType implements Serializable {

    private static final long serialVersionUID=1L;

    private Long typeId;

    private String typeName;

    private Long createId;

    private LocalDateTime creatorTime;

    private LocalDateTime updateTime;

    private Long updateId;

    private String address;

    private Integer isDelete;


}
