package com.goods.gBooks.books.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goods.gBooks.books.dto.in.BooksInDto;
import com.goods.gBooks.books.dto.out.BooksOutDto;
import com.goods.gBooks.books.svc.BooksSvc;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BooksSvc booksSvc;

    @PostMapping("/resister")
    public BooksOutDto register(@RequestBody BooksInDto inDto){
        BooksOutDto outDto = booksSvc.registerBooks(inDto);
        return outDto;
    }

    @PostMapping("/update")
    public BooksOutDto update(@RequestBody BooksInDto inDto){
        BooksOutDto outDto = booksSvc.updateBooks(inDto);
        return outDto;
    }

    @PostMapping("/getBooksInfo")
    public BooksOutDto getBooksInfo(@RequestBody Map<String, String> request) {
        String booksId = request.get("bookId");
         return BooksOutDto.builder().id(booksId).build();
    }

    @PostMapping("/getBookId")
    public String getBookId() {
         return booksSvc.getBookId();
    }
}
