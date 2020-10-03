package com.example.family.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUtil {

    @Value("${calarck.local_service_address}")
    private static String localImageAddress;

    public static String saveImage(MultipartFile file){
        if (file!=null&&file.getSize()>0){
            String fileName=file.getOriginalFilename();
//            String suffixName=fileName.substring(fileName.lastIndexOf("."));
            String filePath=localImageAddress;
            String targetFile=filePath+fileName;
            File file1=new File(targetFile);
            if (!file1.getParentFile().exists()){
                file1.getParentFile().mkdirs();
            }
            try {
                file.transferTo(file1);
                return "/calarck/images/"+fileName;
            }catch (Exception e){
                e.printStackTrace();
                return e.getMessage();
            }
        }
        return "文件为空";
    }
}
