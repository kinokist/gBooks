package com.goods.gBooks.books.svc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goods.gBooks.books.repository.BooksRepository;

@Service
public class BooksSvc {
    @Autowired
    private BooksRepository booksRepository;

    public String getBookId() {
        String genId;
        do {
            genId = idGeneratorType1();  // ID 생성
        } while (booksRepository.existsById("BOOK-" + genId));  // 존재하면 다시 생성
    
        return "BOOK-" + genId;
    }

    public String idGeneratorType1() {
        String date = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        int random = new Random().nextInt(90000) + 10000; // 5자리 랜덤 숫자
        return  date + "-" + random;
    }
}
