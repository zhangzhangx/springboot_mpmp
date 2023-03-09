package com.example.ssmp.Service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ssmp.Dao.Bookdao;
import com.example.ssmp.Service.BookService;
import com.example.ssmp.doman.Book;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//实现类
@Service
//定义为业务层对应的bean
public class BookServiceImpl implements BookService {

//    写入数据层
    @Autowired
    private Bookdao bookdao;
    @Override
    public Boolean save(Book book) {
//        数据层返回一个行计数
        return bookdao.insert(book)>0;
    }

    @Override
    public Boolean update(Book book) {
        return bookdao.updateById(book)>0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookdao.deleteById(id)>0;
    }

    @Override
    public Book getById(Integer id) {
        return bookdao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookdao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int Pagesize) {
        IPage page=new Page(currentPage,Pagesize);
        bookdao.selectPage(page,null);
        return page;
    }



}
