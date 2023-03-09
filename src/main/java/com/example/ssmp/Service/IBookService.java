package com.example.ssmp.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ssmp.doman.Book;
import lombok.Lombok;

public interface IBookService extends IService<Book> {
    Boolean save_message(Book book);
    Boolean update_message(Book book);
    IPage<Book> getPage(int current_page,int page_size);

    IPage<Book> getPage(int current_page, int page_size, Book book);
}
