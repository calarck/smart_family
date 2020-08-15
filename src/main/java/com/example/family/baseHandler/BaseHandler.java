package com.example.family.baseHandler;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("base_handler")
public class BaseHandler {
    private final static ThreadLocal<Map<String,String>> baseHandler = new ThreadLocal<>();
    private static Map<String,String> map=new HashMap<>();

    public static void setCurrentUserID(String userID){
        map.put("currentUserID",userID);
        baseHandler.set(map);
    }

    public static void setCurrentUserName(String userName){
        map.put("currentUserName",userName);
        baseHandler.set(map);
    }

    public static void setCurrentUserPhone(String userPhone){
        map.put("currentUserPhone",userPhone);
        baseHandler.set(map);
    }

    public static void setCurrentUserType(String userType){
        map.put("currentUserType",userType);
        baseHandler.set(map);
    }

    public static String getCurrentUserID(){
        return baseHandler.get().get("currentUserID");
    }

    public static String getCurrentUserName(){
        return baseHandler.get().get("currentUserName");
    }

    public static String getCurrentUserPhone(){
        return baseHandler.get().get("currentUserPhone");
    }

    public static String getCurrentUserType(){
        return baseHandler.get().get("currentUserType");
    }
}
