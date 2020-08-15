package com.example.family.user.controller;


import com.example.family.commen.PassToken;
import com.example.family.commen.Response;
import com.example.family.commen.UserLoginToken;
import com.example.family.user.entity.UserInfo;
import com.example.family.user.service.IUserInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
@RestController
@RequestMapping("/userInfo")
@Api(tags = "用户信息")
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoService;

    @PostMapping("/login")
    @ApiOperation(value = "登录",notes = "登录",httpMethod = "POST")
    @PassToken
    public Response login(@RequestBody UserInfo info){
        return Response.newSuccessInstance(userInfoService.loginByPhone(info));
    }

    @GetMapping("/userMsg")
    @ApiOperation(value = "用户信息",notes = "用户信息",httpMethod = "GET")
    @UserLoginToken
    public Response userMsg(){
        return Response.newSuccessInstance(userInfoService.getUserMsg());
    }
}

