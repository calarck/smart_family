package com.example.family.user.service;

import com.example.family.user.entity.UserType;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
public interface IUserTypeService extends IService<UserType> {

    public int addUserType(UserType userType);

    public int updateUserType(UserType userType);

    public int deleteUserType(Long typeID);

    public List<UserType> getUseTypeByCondition(String typeName);
}
