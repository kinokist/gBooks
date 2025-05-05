package main.java.com.goods.gBooks.books.controller;

import java.util.Map;

import main.java.com.goods.gBooks.books.dto.out.BooksOutDto;

@RestController
@RequestMapping("/api/books")
public class BooksController {
        @PostMapping("/getBooksInfo")
    public BooksOutDto getBooksInfo(@RequestBody Map<String, Long> request) {
        String booksId = request.get("booksId");
         return BooksOutDto.builder().id(booksId).build();
    }
}
