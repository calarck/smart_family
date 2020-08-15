package com.example.family.commen;

public class Response extends BaseResult{
    public Response(boolean success, String msg, Object data) {
        super(success, msg, data);
    }

    public static Response newSuccessInstance(Object data) {
        return new Response(true,"执行成功",data);
    }
}
