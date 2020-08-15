package com.example.family.util;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.family.user.dto.UserInfoDto;
import com.example.family.user.entity.UserInfo;

public class JwtUtil {

    public static String getToken(UserInfo user) {
        String token="";
        token= JWT.create().withAudience(JSONObject.toJSONString(new UserInfoDto(user.getUserFdId(),user.getUserName(),user.getUserPhone(),System.currentTimeMillis())))
                .sign(Algorithm.HMAC256(user.getUserPass()));
        return token;
    }

}
