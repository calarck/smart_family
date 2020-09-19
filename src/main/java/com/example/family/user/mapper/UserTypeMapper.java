package com.example.family.user.mapper;

import com.example.family.user.entity.UserType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
public interface UserTypeMapper extends BaseMapper<UserType> {

    public int addUserType(@Param("userType") UserType userType);

    public int updateUserType(@Param("userType") UserType userType);

    public List<UserType> getUseTypeByCondition(@Param("typeName") String typeName);

    public UserType getUserType(@Param("typeId") Long typeId);

}
