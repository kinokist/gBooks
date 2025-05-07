package com.goods.gBooks.books.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goods.gBooks.books.dto.out.BooksOutDto;

@Mapper
public interface BooksMapper {
    List<BooksOutDto> selectBooksByClient(String client);
}
