package com.example.family.user.service;

import com.example.family.user.dto.UserInfoDto2;
import com.example.family.user.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
public interface IUserInfoService extends IService<UserInfo> {

    public UserInfoDto2 loginByPhone(UserInfo userInfo);

    public UserInfoDto2 getUserMsg();

}
