package com.example.ssmp.Dao.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ssmp.Service.BookService;
import com.example.ssmp.Service.IBookService;
import com.example.ssmp.doman.Book;
import lombok.Lombok;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestcase2 {

//    注入业务层接口
    @Autowired
    IBookService iBookService;

    @Test
    void testGetByid(){
        System.out.println(iBookService.getById(1));
    }


    @Test
    void testSave(){
        Book book=new Book();
        book.setName("测试数据1");
        book.setType("测试数据1");
        book.setDescription("测试数据1");
        iBookService.save(book);

    }
    @Test
    void testUpdate(){
        Book book=new Book();
        book.setName("测试数据3");
        book.setId(3);
        book.setType("测试数据3");
        book.setDescription("测试数据3");
        iBookService.updateById(book);

    }
    @Test
    void testDelete(){
        iBookService.removeById(3);
    }
    @Test
    void testGetAll(){
//        查询所有数据
        System.out.println(iBookService.list());
    }
    @Test
    void testgetPage(){
//创建一个Ipage 对象
//        current 当前页 size 每个页面有几条数据

        IPage<Book> Page = new Page<Book>(1,2);
        IPage<Book> iPage = iBookService.page(Page);
        System.out.println("一共多少页"+iPage.getPages());
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
