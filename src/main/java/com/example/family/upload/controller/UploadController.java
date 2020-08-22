package com.example.family.upload.controller;

import com.example.family.commen.PassToken;
import com.example.family.commen.Response;
import com.example.family.upload.service.UploadService;
import com.example.family.util.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@Api("上传文件")
@Slf4j
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/uploadImage")
    @ApiOperation(value = "无token文件上传",notes = "无token文件上传",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "图片",required = true,dataType = "file")
    })
    @PassToken
    public Response uploadImage(@RequestParam(value = "image") MultipartFile image){
        return Response.newSuccessInstance(uploadService.uploadImage(image));
    }

    @PostMapping("/updateImage")
    @ApiOperation(value = "更新图片",notes = "更新图片",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "图片",required = true,dataType = "file")
    })
    public Response updateImage(@RequestParam(value = "image") MultipartFile image){
        return Response.newSuccessInstance(uploadService.updateImage(image));
    }

}
