package com.stu212306105.helloserver.exception;

import com.stu212306105.helloserver.common.Result;
import com.stu212306105.helloserver.common.ResultCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public Result<String> handleRuntimeException(RuntimeException e) {
        return Result.error(ResultCode.ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result<String> handleTokenException(IllegalArgumentException e) {
        return Result.error(ResultCode.TOKEN_INVALID);
    }
}