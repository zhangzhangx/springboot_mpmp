package com.example.ssmp.Dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ssmp.doman.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private Bookdao bookdao;

    @Test
    void testById(){
        System.out.println(bookdao.selectById(1));
    }

    @Test
    void testSave(){
        Book book=new Book();
        book.setName("测试数据1");
        book.setType("测试数据1");
        book.setDescription("测试数据1");
        bookdao.insert(book);
        System.out.println("hello");
        System.out.println("hello hot-fix");
        System.out.println("hello master");

    }
    @Test
    void testUpdate(){
        Book book=new Book();
        book.setName("测试数据2");
        book.setId(2);
        book.setType("测试数据2");
        book.setDescription("测试数据2");
        bookdao.updateById(book);

    }
    @Test
    void testDelete(){
        bookdao.deleteById(2);
    }
    @Test
    void testGetAll(){
//        查询所有数据
        System.out.println(bookdao.selectList(null));
    }
    @Test
    void testgetPage(){
//创建一个Ipage 对象
//        current 当前页 size 每个页面有几条数据
        IPage iPage=new Page(2,2);
        System.out.println(bookdao.selectPage(iPage, null));
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
    @Test
    void testGetby(){

        QueryWrapper<Book> qw =new QueryWrapper();
        qw.like("name","spring实战");
        System.out.println(bookdao.selectList(qw));
    }

    @Test
    void testGetby2(){

        String name="1";
        LambdaQueryWrapper<Book> lqw =new LambdaQueryWrapper();
        lqw.like(name!=null,Book::getName,name);
//        System.out.println(bookdao.selectList(qw));
        bookdao.selectList(lqw);
    }

}
