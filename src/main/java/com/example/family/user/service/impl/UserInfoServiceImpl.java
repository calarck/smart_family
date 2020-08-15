package com.example.family.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.example.family.baseHandler.BaseHandler;
import com.example.family.commen.FamilyException;
import com.example.family.user.dto.UserInfoDto2;
import com.example.family.user.entity.UserInfo;
import com.example.family.user.mapper.UserInfoMapper;
import com.example.family.user.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.family.util.JwtUtil;
import com.example.family.util.MapperUtil;
import com.example.family.util.RedisUtil;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

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

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public UserInfoDto2 loginByPhone(UserInfo userInfo) {
        QueryWrapper<UserInfo> wrapper=new QueryWrapper<>();
        wrapper.eq("user_phone",userInfo.getUserPhone());
        wrapper.eq("user_pass",userInfo.getUserPass());
        UserInfo userInfo1 = super.getOne(wrapper);
        if (null==userInfo1){
            throw new FamilyException("账号或密码错误");
        }
        String token= JwtUtil.getToken(userInfo1);
        redisUtil.set(token,token,60*60*24);
        UserInfoDto2 dto2= MapperUtil.INSTANCE.map(UserInfoDto2.class,userInfo1);
        dto2.setToken(token);
        return dto2;
    }

    @Override
    public UserInfoDto2 getUserMsg() {
        UserInfo byId = getOne(new QueryWrapper<UserInfo>().eq("user_fd_id",BaseHandler.getCurrentUserID()));
        UserInfoDto2 dto2=MapperUtil.INSTANCE.map(UserInfoDto2.class,byId);
        return dto2;
    }
}
