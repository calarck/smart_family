package com.example.family.coast.entity;

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
@ApiModel(value="CoastItem对象", description="")
public class CoastItem implements Serializable {

    private static final long serialVersionUID=1L;

    private Long idcoastItem;

    private String coastName;

    private Integer coastType;

    private LocalDateTime createTime;

    private Long creatorId;

    private LocalDateTime updateTime;

    private Long updatorId;

    private Integer isDelete;


}
