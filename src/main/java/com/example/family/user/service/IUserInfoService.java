package com.example.family.user.service;

import com.example.family.user.dto.UserInfoDto2;
import com.example.family.user.entity.UserInfo;
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
public interface IUserInfoService extends IService<UserInfo> {

    public UserInfoDto2 loginByPhone(UserInfo userInfo);

    public UserInfoDto2 getUserMsg();

    public UserInfoDto2 registerTenant(UserInfo userInfo);

    public UserInfoDto2 registerFamily(UserInfo userInfo);

    public UserInfoDto2 registerChildren(UserInfo userInfo);

    public String updateUserPS(String oldPs,String newPs);

    public String deleteUserById(Long userId);

    public List<UserInfoDto2> getAllUser();
}
