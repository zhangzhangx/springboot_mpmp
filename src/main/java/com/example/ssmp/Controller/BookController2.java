package com.example.ssmp.Controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ssmp.Service.IBookService;
import com.example.ssmp.doman.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//使用rest风格 加载成bean
//@RestController
//设置公共请求路径前缀
@RequestMapping("/books")
public class BookController2 {

//    装配 应用层借口哦
    @Autowired
   private IBookService iBookService;

    @GetMapping
    public List<Book> getAll(){

        return iBookService.list();
    }
//    post 请求方式
    @PostMapping
//    @RequestBody 请求体参数 传json 数据过来
    public Boolean save(@RequestBody Book book){
        return  iBookService.save(book);
    }

//    update put方式提交
    @PutMapping
    public  boolean update(@RequestBody Book book){

        return iBookService.updateById(book);
    }

//    delete delete 方式提交
    @DeleteMapping("{id}")
//    @PathVariable 表明数据来源
    public  boolean delete(@PathVariable Integer id){

        return iBookService.removeById(id);
    }
//    类似于 http://;localhost/books/id
    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id){
        return iBookService.getById(id);
    }
//    分页查询
    @GetMapping("{current_page}/{pagesize}")
    public IPage<Book> getPage(@PathVariable  int current_page,@PathVariable int pagesize){

        return iBookService.getPage(current_page,pagesize,null);

    }





}
