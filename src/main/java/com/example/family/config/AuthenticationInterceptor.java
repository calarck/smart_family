package com.example.family.config;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.family.baseHandler.BaseHandler;
import com.example.family.commen.FamilyException;
import com.example.family.commen.PassToken;
import com.example.family.commen.UserLoginToken;
import com.example.family.user.dto.UserInfoDto;
import com.example.family.user.entity.UserInfo;
import com.example.family.user.service.IUserInfoService;
import com.example.family.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor{
    @Autowired
    private IUserInfoService service;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("AuthenticToken");
        //不是映射到方法的跳过
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod= (HandlerMethod) handler;
        Method method=handlerMethod.getMethod();
        if (method.isAnnotationPresent(PassToken.class)){
            return true;
        }
        if (method.isAnnotationPresent(UserLoginToken.class)){
            if (token==null){
                //抛出异常
                throw new FamilyException("请重新登入");
            }
            //TODO 验证token无效
            UserInfoDto userInfoDto;
            try {
                 userInfoDto = JSON.parseObject(JWT.decode(token).getAudience().get(0), UserInfoDto.class);
            }catch (JWTDecodeException j){
                throw new FamilyException("请重新登入");
            }

            //判断是否在redis中
            Object key = redisUtil.get(token);
            //过期了或者被删除了
            if (key==null){
                throw new FamilyException("请重新登入");
            }


            UserInfo userInfo=service.getOne(new QueryWrapper<UserInfo>().eq("user_fd_id",userInfoDto.getUserId()));
            if (userInfo==null){
                throw new FamilyException("用户不存在，请注册");
            }
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(userInfo.getUserPass())).build();
            try {
                jwtVerifier.verify(token);
            }catch (JWTVerificationException v){
                throw new FamilyException("请重新登入");
            }
            BaseHandler.setCurrentUserID(String.valueOf(userInfo.getUserFdId()));
            BaseHandler.setCurrentUserName(userInfo.getUserName());
            BaseHandler.setCurrentUserPhone(userInfo.getUserPhone());
            BaseHandler.setCurrentUserType(String.valueOf(userInfo.getUserType()));
            return true;
        }
        return true;
    }
}
