package com.example.ssmp.Controller.utils;

import lombok.Data;

//省略get 和set 方法
@Data
public class R {
    
    private Boolean flag;
    private Object data;
    private String msg;
    public R(){}
    public R(boolean flage){
        this.flag=flage;

    }
    public R(boolean flag,Object data){
        this.flag=flag;
        this.data=data;

    }
    public R(String msg){
        this.flag=false;
        this.msg=msg;
    }
    public R(boolean flag,String msg){
        this.flag=flag;
        this.msg=msg;
    }

}
