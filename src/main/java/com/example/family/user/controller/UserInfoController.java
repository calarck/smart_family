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

    @PostMapping("/registerTenant")
    @ApiOperation(value = "租户注册",notes = "租户注册",httpMethod = "POST")
    @PassToken
    public Response registerTenant(@RequestBody UserInfo info){
        return Response.newSuccessInstance(userInfoService.registerTenant(info));
    }

    @PostMapping("/registerFamily")
    @ApiOperation(value = "家人注册",notes = "家人注册",httpMethod = "POST")
    @PassToken
    public Response registerFamily(@RequestBody UserInfo info){
        return Response.newSuccessInstance(userInfoService.registerFamily(info));
    }

    @PostMapping("/registerChildren")
    @ApiOperation(value = "孩子注册",notes = "孩子注册",httpMethod = "POST")
    @PassToken
    public Response registerChildren(@RequestBody UserInfo info){
        return Response.newSuccessInstance(userInfoService.registerChildren(info));
    }

    @GetMapping("/updateUserPS")
    @UserLoginToken
    @ApiOperation(value = "更新密码",notes = "更新密码",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "olderPs",name = "olderPs",required = true,dataType = "String"),
            @ApiImplicitParam(value = "newPs",name = "newPs",required = true,dataType = "String")
    })
    public Response updateUserPS(String olderPs,String newPs){
        return Response.newSuccessInstance(userInfoService.updateUserPS(olderPs,newPs));
    }

    @GetMapping("/deleteUser")
    @UserLoginToken
    @ApiOperation(value = "根据用户ID删除用户",notes = "根据用户ID删除用户",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "userId",name = "userId",required = true,dataType = "Long")
    })
    public Response DeleteUserById(Long userId){
        return Response.newSuccessInstance(userInfoService.deleteUserById(userId));
    }
}

