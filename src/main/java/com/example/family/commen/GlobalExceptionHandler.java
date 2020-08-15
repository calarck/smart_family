package com.example.family.commen;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常统一处理
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = FamilyException.class)
    public BaseResult FamilyExceptionHandler(FamilyException e){
        return new BaseResult(false,e.getMessage(),null);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResult OtherExceptionHandler(Exception e){
        return new BaseResult(false,e.getMessage(),null);
    }

}
