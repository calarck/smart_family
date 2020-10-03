package com.example.family.upload.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.family.baseHandler.BaseHandler;
import com.example.family.user.entity.UserInfo;
import com.example.family.user.service.IUserInfoService;
import com.example.family.util.FileUtil;
import com.example.family.util.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

    @Autowired
    private IUserInfoService userInfoService;

    public String uploadImage(MultipartFile image){
        return FileUtil.saveImage(image);
    }

    public String updateImage(MultipartFile image){
        if (image==null||image.getSize()==0){
            return "请上传文件";
        }
        String imagePath=FileUtil.saveImage(image);
        String userID= BaseHandler.getCurrentUserID();
        UpdateWrapper<UserInfo> updateWrapper=new UpdateWrapper<>();
        updateWrapper.set("user_image",imagePath);
        updateWrapper.eq("user_fd_id",userID);
        userInfoService.update(updateWrapper);
        return "http://"+NetUtil.getInstance().getIpv4()+":8086"+imagePath;
    }
}
