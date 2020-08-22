package com.example.family.coast.mapper;

import com.example.family.coast.dto.CoastItemDto;
import com.example.family.coast.entity.CoastItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
public interface CoastItemMapper extends BaseMapper<CoastItem> {
    public List<CoastItemDto> getAllItem();
}
