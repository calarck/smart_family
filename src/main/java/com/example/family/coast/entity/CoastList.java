package com.example.family.coast.entity;

import java.math.BigDecimal;
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
@ApiModel(value="CoastList对象", description="")
public class CoastList implements Serializable {

    private static final long serialVersionUID=1L;

    private Long coastId;

    private Integer coastorId;

    private Integer coastType;

    private BigDecimal coastCount;

    private Integer creatorId;

    private LocalDateTime createTime;

    private Integer updateorId;

    private LocalDateTime updateTime;

    private String remark;

    private Integer isDelete;


}
