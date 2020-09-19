package com.example.family.coast.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.family.baseHandler.BaseHandler;
import com.example.family.coast.dto.CoastItemDto;
import com.example.family.coast.entity.CoastItem;
import com.example.family.coast.mapper.CoastItemMapper;
import com.example.family.coast.service.ICoastItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.family.util.DataUtil;
import com.example.family.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
@Service
public class CoastItemServiceImpl extends ServiceImpl<CoastItemMapper, CoastItem> implements ICoastItemService {

    @Resource
    private CoastItemMapper coastItemMapper;

    @Override
    public String insertItem(CoastItem item) {
        DataUtil.isEmpty(item.getCoastName(),"项目名称为空");
        DataUtil.isNull(item.getCoastType(),"项目类型为空");
        Long itemID=System.currentTimeMillis()/1000;
        item.setIdcoastItem(itemID);
        item.setCreatorId(Long.parseLong(BaseHandler.getCurrentUserID()));
        item.setCreateTime(DateTimeUtil.getDateTime());
        save(item);
        return "保存成功";
    }

    @Override
    public String deleteItem(Long id) {
        DataUtil.isNull(id,"项目编号为空");
        String currentUserType = BaseHandler.getCurrentUserType();
        if (!currentUserType.contains("管理员")){
            return "您无权删除";
        }
        //TODO 要判断是否存在
        UpdateWrapper<CoastItem> itemQueryWrapper=new UpdateWrapper<>();
        itemQueryWrapper.eq("id_coast",id);
        itemQueryWrapper.set("is_delete",1);
        itemQueryWrapper.set("updator_id",BaseHandler.getCurrentUserID());
        itemQueryWrapper.set("update_time",DateTimeUtil.getCurrentDateTime());
        super.update(itemQueryWrapper);
        return "删除成功";
    }

    @Override
    public List<CoastItemDto> getAllList() {
        return coastItemMapper.getAllItem();
    }

    @Override
    public String updateItem(Long id, String name, Integer type) {
        //TODO 要判断项目是否存在
        DataUtil.isNull(id,"要更新的项目为空");
        if (!BaseHandler.getCurrentUserType().contains("超级")){
            return "您无权限更新";
        }
        CoastItem coastItemByID = coastItemMapper.getCoastItemByID(id);
        DataUtil.isNull(coastItemByID);
        coastItemByID.setCoastType(type);
        coastItemByID.setCoastName(name);
        super.updateById(coastItemByID);
        return "更新成功";
    }
}
