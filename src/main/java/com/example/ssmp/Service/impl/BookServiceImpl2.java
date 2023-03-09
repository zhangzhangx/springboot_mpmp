package com.example.ssmp.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ssmp.Dao.Bookdao;
import com.example.ssmp.Service.BookService;
import com.example.ssmp.Service.IBookService;
import com.example.ssmp.doman.Book;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl2  extends ServiceImpl<Bookdao,Book> implements IBookService {

    @Autowired
    private Bookdao bookdao;

    @Override
    public Boolean save_message(Book book) {
        return bookdao.insert(book)>0;
    }

    @Override
    public Boolean update_message(Book book) {
        return bookdao.updateById(book)>0;
    }

    @Override
    public IPage<Book> getPage(int current_page, int page_size) {
        IPage page=new Page(current_page,page_size);
        bookdao.selectPage(page,null);
        return page;
    }

/*
LambdaQueryWrapper
第一个参数：该参数是一个布尔类型，只有该参数是true时，才将like条件拼接到sql中；本例中，如果name字段不为空，则拼接name字段的like查询条件；
第二个参数：该参数是数据库中的字段名；
第三个参数：该参数值字段值；
 */

    @Override
    public IPage<Book> getPage(int current_page, int pagesize, Book book) {
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<Book>();
        System.out.println(Strings.isNotEmpty(book.getType()));

        lqw.like(Strings.isNotEmpty(book.getType()+""),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()+""),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()+""),Book::getDescription,book.getDescription());
        IPage page=new Page(current_page,pagesize);
        bookdao.selectPage(page,lqw);
        return page;
    }
}
