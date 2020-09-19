package com.example.family.user.controller;


import com.example.family.commen.Response;
import com.example.family.user.entity.UserType;
import com.example.family.user.mapper.UserTypeMapper;
import com.example.family.user.service.IUserTypeService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/usertype")
public class UserTypeController {

    @Autowired
    private IUserTypeService userTypeService;

    @PostMapping("/addUserType")
    @ApiOperation(value = "添加用户类别",notes = "添加用户类别",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "userType",name = "用户类型",required = true,dataType = "UserType",paramType = "query")
    })
    public Response addUserType(@RequestBody UserType userType){
        return Response.newSuccessInstance(userTypeService.addUserType(userType));
    }

    @PostMapping("/updateUserType")
    @ApiOperation(value = "更新用户类别",notes = "更新用户类别",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "userType",name = "更新用户信息",required = true,dataType = "UserType",paramType = "query")
    })
    public Response updateUserType(UserType userType){
        return Response.newSuccessInstance(userTypeService.updateUserType(userType));
    }

    @GetMapping("/deleteUserType")
    @ApiOperation(value = "删除用户",notes = "删除用户",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "userTypeID",name = "用户ID",required = true,paramType = "query",dataType = "Long")
    })
    public Response deleteUserType(Long userTypeID){
        return Response.newSuccessInstance(userTypeService.deleteUserType(userTypeID));
    }

    @GetMapping("/getUserTypeByCondition")
    @ApiOperation(value = "根据类型名获取类型",notes = "根据类型名获取类型",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "typeName",name = "类型名称",required = true,paramType = "query",dataType = "String")
    })
    public Response getUserTypeByCondition(String typeName){
        return Response.newSuccessInstance(userTypeService.getUseTypeByCondition(typeName));
    }
}

