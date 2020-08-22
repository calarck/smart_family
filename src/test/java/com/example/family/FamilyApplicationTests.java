package com.example.family;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.family.user.entity.UserInfo;
import com.example.family.user.entity.UserType;
import com.example.family.user.mapper.UserInfoMapper;
import com.example.family.user.service.IUserInfoService;
import com.example.family.user.service.IUserTypeService;
import com.example.family.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class FamilyApplicationTests {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private IUserTypeService iUserTypeService;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
       /* QueryWrapper<UserInfo> wrapper=new QueryWrapper<>();
        wrapper.eq("user_fd_id",1130621);
        UserInfo userInfo = userInfoMapper.selectOne(wrapper);

        log.info(JSONObject.toJSONString(userInfo));*/
        UserInfo byId = iUserInfoService.getById(1130621);
        UserType byId1 = iUserTypeService.getById(1);
        UserInfo userInfo = userInfoMapper.selectById(Long.parseLong("1130621"));
        System.out.println(userInfo);
    }

    @Test
    void redisTest(){
        //redisUtil.set("springboot","123",5*60);
        System.out.println(redisUtil.get("springboot"));
    }

    @Test
    void testDataLong(){
        System.out.println(System.currentTimeMillis());
    }

}
