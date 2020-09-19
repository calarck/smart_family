package com.example.family.coast.controller;


import com.example.family.coast.entity.CoastItem;
import com.example.family.coast.service.ICoastItemService;
import com.example.family.commen.Response;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author calarck
 * @since 2020-08-02
 */
@RestController
@RequestMapping("/coastItem")
public class CoastItemController {

    @Resource
    private ICoastItemService service;

    @PostMapping("/insertItem")
    @ApiOperation(value = "新增消费项目",notes = "新增消费项目",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "消费类型",value = "item",required = true,paramType = "query")
    })
    public Response insertItem(CoastItem item){
        return Response.newSuccessInstance(service.insertItem(item));
    }

    @GetMapping("/deleteItem")
    @ApiOperation(value = "删除消费项目",notes = "删除消费项目",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "项目id",value = "id",required = true,dataType = "Long",paramType = "query")
    })
    public Response deleteItem(Long id){
        return Response.newSuccessInstance(service.deleteItem(id));
    }

    @GetMapping("/getAllList")
    @ApiOperation(value = "获取消费项目列表",notes = "获取消费项目列表",httpMethod = "GET")
    public Response getAllList(){
        return Response.newSuccessInstance(service.getAllList());
    }

}

