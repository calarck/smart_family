package com.example.family.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.family.baseHandler.BaseHandler;
import com.example.family.commen.FamilyException;
import com.example.family.user.dto.UserInfoDto2;
import com.example.family.user.entity.UserInfo;
import com.example.family.user.entity.UserType;
import com.example.family.user.mapper.UserInfoMapper;
import com.example.family.user.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.family.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Value("${calarck.base_image_path}")
    private String baseImagePath;

    @Override
    public UserInfoDto2 loginByPhone(UserInfo userInfo) {
        QueryWrapper<UserInfo> wrapper=new QueryWrapper<>();
        wrapper.eq("user_phone",userInfo.getUserPhone());
        wrapper.eq("user_pass",userInfo.getUserPass());
        if (userInfo.getUserType()!=null)
        wrapper.eq("user_type",userInfo.getUserType());
        UserInfo userInfo1 = super.getOne(wrapper);
        if (null==userInfo1){
            throw new FamilyException("账号或密码错误");
        }
        String token= JwtUtil.getToken(userInfo1);
        redisUtil.set(token,token,60*60*24);
        userInfo1.setUserImage("http://"+NetUtil.getInstance().getIpv4()+":8086"+baseImagePath);
        UserInfoDto2 dto2= MapperUtil.INSTANCE.map(UserInfoDto2.class,userInfo1);
        dto2.setToken(token);
        return dto2;
    }

    @Override
    public UserInfoDto2 getUserMsg() {
        UserInfo byId = getOne(new QueryWrapper<UserInfo>().eq("user_fd_id",BaseHandler.getCurrentUserID()));
        byId.setUserImage("http://"+NetUtil.getInstance().getIpv4()+":8086"+baseImagePath);
        UserInfoDto2 dto2=MapperUtil.INSTANCE.map(UserInfoDto2.class,byId);
        return dto2;
    }

    @Override
    public UserInfoDto2 registerTenant(UserInfo userInfo) {
        DataUtil.isEmpty(userInfo.getUserName(),"用户名为空");
        DataUtil.isEmpty(userInfo.getUserPass(),"用户密码为空");
        DataUtil.isEmpty(userInfo.getUserPhone(),"用户手机号为空");
        if (DataUtil.isEmpty(userInfo.getUserImage())){
            userInfo.setUserImage(baseImagePath);
        }
        userInfo.setUpdateTime(DateTimeUtil.getDateTime());
        userInfo.setUserType(4);
        userInfo.setIsDelete(0);
        long userID=IdWorker.getId();
        userInfo.setUserFdId(userID);
        userInfoMapper.insert(userInfo);
        return MapperUtil.INSTANCE.map(UserInfoDto2.class,userInfo);
    }

    @Override
    public UserInfoDto2 registerFamily(UserInfo userInfo) {
        DataUtil.isEmpty(userInfo.getUserName(),"用户名为空");
        DataUtil.isEmpty(userInfo.getUserPass(),"用户密码为空");
        DataUtil.isEmpty(userInfo.getUserPhone(),"用户手机号为空");
        if (DataUtil.isEmpty(userInfo.getUserImage())){
            userInfo.setUserImage(baseImagePath);
        }
        userInfo.setUpdateTime(DateTimeUtil.getDateTime());
        userInfo.setUserType(2);
        userInfo.setIsDelete(0);
        long userID=IdWorker.getId();
        userInfo.setUserFdId(userID);
        userInfoMapper.insert(userInfo);
        return MapperUtil.INSTANCE.map(UserInfoDto2.class,userInfo);
    }

    @Override
    public UserInfoDto2 registerChildren(UserInfo userInfo) {
        DataUtil.isEmpty(userInfo.getUserName(),"用户名为空");
        DataUtil.isEmpty(userInfo.getUserPass(),"用户密码为空");
        DataUtil.isEmpty(userInfo.getUserPhone(),"用户手机号为空");
        if (DataUtil.isEmpty(userInfo.getUserImage())){
            userInfo.setUserImage(baseImagePath);
        }
        userInfo.setUpdateTime(DateTimeUtil.getDateTime());
        userInfo.setUserType(3);
        userInfo.setIsDelete(0);
        long userID=IdWorker.getId();
        userInfo.setUserFdId(userID);
        userInfoMapper.insert(userInfo);
        return MapperUtil.INSTANCE.map(UserInfoDto2.class,userInfo);
    }

    @Override
    public String updateUserPS(String oldPs, String newPs) {
        DataUtil.isEmpty(oldPs,"请输入原始密码");
        DataUtil.isEmpty(newPs,"请输入新密码");
        QueryWrapper<UserInfo> wrapper=new QueryWrapper<>();
        String userId=BaseHandler.getCurrentUserID();
        wrapper.eq("user_fd_id",userId);
        wrapper.eq("user_pass",oldPs);
        UserInfo one = getOne(wrapper);
        if (null==one){
            return "密码错误";
        }
        if (oldPs.equals(newPs)){
            return "新旧密码不能一样";
        }
        UpdateWrapper<UserInfo> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("user_pass",newPs);
        updateWrapper.eq("user_fd_id",userId);
        update(wrapper);
        return "更新成功,请重新登入";
    }

    @Override
    public String deleteUserById(Long userId) {
        DataUtil.isNull(userId,"用户ID不能为空");;
        if (!BaseHandler.getCurrentUserType().contains("超级管理员")){
            return "权限不够";
        }
        UpdateWrapper<UserInfo> userTypeUpdateWrapper=new UpdateWrapper<>();
        userTypeUpdateWrapper.set("is_delete",1);
        userTypeUpdateWrapper.set("updator_id",BaseHandler.getCurrentUserID());
        userTypeUpdateWrapper.set("update_time",DateTimeUtil.getDateTime());
        userTypeUpdateWrapper.eq("user_fd_id",userId);
        super.update(userTypeUpdateWrapper);
        return "删除成功";
    }

}
