package com.example.ssmp.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ssmp.doman.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Bookdao  extends BaseMapper<Book> {

}
