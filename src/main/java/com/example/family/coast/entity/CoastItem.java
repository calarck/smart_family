package com.example.family.coast.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2020-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="CoastItem对象", description="")
public class CoastItem implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "idcoast_item", type = IdType.ASSIGN_ID)
    private Integer idcoastItem;

    private String coastName;

    private Integer coastType;

    private LocalDateTime createTime;

    private Integer creatorId;

    private LocalDateTime updateTime;

    private Integer updatorId;

    private Integer isDelete;


}
