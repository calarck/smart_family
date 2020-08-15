package com.example.family.commen;

import lombok.Data;

@Data
public class BaseResult<T> {
    private boolean success;
    private String msg;
    private T data;

    public BaseResult(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }
}
