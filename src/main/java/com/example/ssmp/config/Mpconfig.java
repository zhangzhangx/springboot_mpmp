package com.example.ssmp.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//为了分页为 mp 配置一个拦截器
@Configuration
public class Mpconfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        定义mp 拦截器
        MybatisPlusInterceptor mpInterceptor=new MybatisPlusInterceptor();
//        添加具体的拦截器
        mpInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpInterceptor;
    }





}
