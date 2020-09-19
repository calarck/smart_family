package com.example.family.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.family.baseHandler.BaseHandler;
import com.example.family.commen.FamilyException;
import com.example.family.user.entity.UserType;
import com.example.family.user.mapper.UserTypeMapper;
import com.example.family.user.service.IUserTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.family.util.DataUtil;
import com.example.family.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserTypeServiceImpl extends ServiceImpl<UserTypeMapper, UserType> implements IUserTypeService {

    @Autowired
    private UserTypeMapper mapper;

    @Override
    public int addUserType(UserType userType) {
        if (!BaseHandler.getCurrentUserType().contains("超级")){
            throw new FamilyException("您无权限");
        }
        DataUtil.isEmpty(userType.getTypeName(),"项目名为空");
        userType.setCreateId(Long.parseLong(BaseHandler.getCurrentUserID()));
        userType.setCreatorTime(DateTimeUtil.getDateTime());
        userType.setIsDelete(0);
        userType.setTypeId(IdWorker.getId());
        return mapper.addUserType(userType);
    }

    @Override
    public int updateUserType(UserType userType) {
        if (!BaseHandler.getCurrentUserType().contains("超级")){
            throw new FamilyException("您无权限");
        }
        userType.setUpdateTime(DateTimeUtil.getDateTime());
        userType.setUpdateId(Long.parseLong(BaseHandler.getCurrentUserID()));
        return mapper.updateUserType(userType);
    }

    @Override
    public int deleteUserType(Long typeID) {
        if (!BaseHandler.getCurrentUserType().contains("超级")){
            throw new FamilyException("您无权限");
        }
        UserType userType = mapper.getUserType(typeID);
        if (userType==null){
            throw new FamilyException("没有此项目");
        }
        userType.setIsDelete(1);
        userType.setUpdateTime(DateTimeUtil.getDateTime());
        userType.setUpdateId(Long.parseLong(BaseHandler.getCurrentUserID()));
        return mapper.updateUserType(userType);
    }

    @Override
    public List<UserType> getUseTypeByCondition(String typeName) {
        return mapper.getUseTypeByCondition(typeName);
    }
}
