package com.example.family.msgpush.controller;

import com.example.family.commen.Response;
import com.example.family.commen.UserLoginToken;
import com.example.family.msgpush.service.MessagePushService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pushMsg")
@Api("消息推送")
public class MessagePushController {
    @Autowired
    private MessagePushService service;

    @UserLoginToken
    @GetMapping("/sendPush")
    @ApiOperation(value = "消息推送",notes = "消息推送",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "message",value = "消息内容",paramType = "query",required = true)
    })
    public Response sendPush(String message){
        return Response.newSuccessInstance(service.sendMessage(message));
    }
}
