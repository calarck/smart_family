package com.example.family.util;

import com.example.family.commen.FamilyException;

public class DataUtil {
    public static void isEmpty(String data,String errorMsg){
            if (null==data||"".equals(data)){
                throw new FamilyException(errorMsg);
            }
    }

    public static void isNull(Object data,String errorMsg){
        if (!(data instanceof String)){
            if (data==null){
                throw new FamilyException(errorMsg);
            }
        }
    }

    public static boolean isEmpty(String data){
        return (data==null||"".equals(data));
    }

    public static boolean isNull(Object data){
        return data==null;
    }

}
