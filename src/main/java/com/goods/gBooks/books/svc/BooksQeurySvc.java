package com.goods.gBooks.books.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goods.gBooks.books.dto.out.BooksOutDto;
import com.goods.gBooks.books.mapper.BooksMapper;

@Service
public class BooksQeurySvc {
    @Autowired
    private BooksMapper mapper;

    public List<BooksOutDto> getProductList(String clinet) {
        return mapper.selectBooksByClient(clinet);
    }
}
