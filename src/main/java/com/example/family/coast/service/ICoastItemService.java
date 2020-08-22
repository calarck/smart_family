package com.example.family.coast.service;

import com.example.family.coast.dto.CoastItemDto;
import com.example.family.coast.entity.CoastItem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
public interface ICoastItemService extends IService<CoastItem> {

    public String insertItem(CoastItem item);

    public String deleteItem(Long id);

    public List<CoastItemDto> getAllList();

    public String updateItem(Long id,String name,Integer type);

}
