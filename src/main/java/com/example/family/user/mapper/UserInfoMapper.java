package com.example.family.user.mapper;

import com.example.family.user.entity.UserInfo;
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
public interface UserInfoMapper extends BaseMapper<UserInfo> {
   List<UserInfo> getAllUser();
}
