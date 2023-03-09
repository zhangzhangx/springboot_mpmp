package com.example.ssmp.Controller.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//作为springmvc 异常处理  数据层业务层 异常会抛到 控制层
//定义为controller 的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler //拦截所有的异常信息
    public R doException(Exception ex){
//        记录日志
//        通知运维
//        通知开发


        ex.printStackTrace(); //控制台打印异常
        return new R("服务器故障 请稍后再试试");

    }



}
