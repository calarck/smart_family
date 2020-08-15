package com.example.family.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserType对象", description="")
public class UserType implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer typeId;

    private String typeName;

    private Integer createId;

    private LocalDateTime creatorTime;

    private LocalDateTime updateTime;

    private Integer updateId;

    private Integer isDelete;


}