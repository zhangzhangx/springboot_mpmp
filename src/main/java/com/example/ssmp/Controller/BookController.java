package com.example.ssmp.Controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ssmp.Controller.utils.R;
import com.example.ssmp.Service.IBookService;
import com.example.ssmp.doman.Book;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

//使用rest风格
@RestController
//设置公共请求路径前缀
@RequestMapping("/books")
public class BookController {

//    装配 应用层借口哦
    @Autowired
   private IBookService iBookService;

    @GetMapping
    public R getAll(){

//        return iBookService.list();
        return new R(true,iBookService.list());
    }
//    post 请求方式
    @PostMapping
//    @RequestBody 请求体参数 传json 数据过来
    public R save(@RequestBody Book book) throws IOException {
//
//        R r=new R();
//
//        r.setFlag(iBookService.save(book));
        if (book.getName().equals("123")) throw new IOException();
        boolean flag=iBookService.save(book);
        return  new R(flag,flag ?"添加成功^-^":"添加失败^~^!");
    }

//    update put方式提交
    @PutMapping
    public  R update(@RequestBody Book book){

        return new R(iBookService.updateById(book));
    }

//    delete delete 方式提交
    @DeleteMapping("{id}")
//    @PathVariable 表明数据来源
    public R delete(@PathVariable Integer id){

        return new R(iBookService.removeById(id));

    }
//    类似于 http://;localhost/books/id
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,iBookService.getById(id));

    }
////    分页查询
//    @GetMapping("{current_page}/{pagesize}")
//    public R getPage(@PathVariable  int current_page,@PathVariable int pagesize){
//        IPage<Book> page = iBookService.getPage(current_page, pagesize);
////        如果当前页码值 大于总页码值 那么重新执行查询操作 使用最大页码值作为当前页码值
////        getPages() 获取总得页数
//        if (current_page>page.getPages()){
//            page = iBookService.getPage((int)page.getPages(), pagesize);
//        }
//        return new R(true,page);
//
//    }
//    分页查询
@GetMapping("{current_page}/{pagesize}")
//写模型类 会自动 把数据丢到模型类中
public R getPage(@PathVariable  int current_page,@PathVariable int pagesize,Book book){
    IPage<Book> page = iBookService.getPage(current_page, pagesize,book);
    System.out.println(book);
    System.out.println(pagesize);
//    System.out.println(page.getPages()+"------");
//        如果当前页码值 大于总页码值 那么重新执行查询操作 使用最大页码值作为当前页码值
//        getPages() 获取总得页数
    if (current_page>page.getPages()){
        page = iBookService.getPage((int)page.getPages(), pagesize,book);
    }
    return new R(true,page);

}





}
