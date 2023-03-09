package com.example.ssmp.Dao.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ssmp.Service.BookService;
import com.example.ssmp.doman.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestcase {

//    注入业务层
    @Autowired
    BookService bookService;

    @Test
    void testGetByid(){
        System.out.println(bookService.getById(1));
    }


    @Test
    void testSave(){
        Book book=new Book();
        book.setName("测试数据1");
        book.setType("测试数据1");
        book.setDescription("测试数据1");
        bookService.save(book);

    }
    @Test
    void testUpdate(){
        Book book=new Book();
        book.setName("测试数据3");
        book.setId(3);
        book.setType("测试数据3");
        book.setDescription("测试数据3");
        bookService.update(book);

    }
    @Test
    void testDelete(){
        bookService.delete(3);
    }
    @Test
    void testGetAll(){
//        查询所有数据
        System.out.println(bookService.getAll());
    }
    @Test
    void testgetPage(){
//创建一个Ipage 对象
//        current 当前页 size 每个页面有几条数据

        IPage<Book> iPage = bookService.getPage(1, 2);
        System.out.println("当前页"+iPage.getPages());
        System.out.println(iPage.getCurrent());
//        数据
        System.out.println(iPage.getRecords());
//        一共有多少条数据
        System.out.println(iPage.getTotal());
//        当前页有几条数据
        System.out.println(iPage.getSize());

    }
    //    按条件查询


}
