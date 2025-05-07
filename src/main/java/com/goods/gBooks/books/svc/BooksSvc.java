package com.goods.gBooks.books.svc;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goods.gBooks.books.dto.in.BooksInDto;
import com.goods.gBooks.books.dto.out.BooksOutDto;
import com.goods.gBooks.books.entity.Books;
import com.goods.gBooks.books.repository.BooksRepository;

@Service
public class BooksSvc {
    @Autowired
    private BooksRepository booksRepository;

    public BooksOutDto registerBooks(BooksInDto inDto) {
        try {
            String id = getBookId();
            inDto.setId(id);

            return save(inDto);

        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("등록 중 예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("등록 실패", e);
        }
    }

    public BooksOutDto updateBooks(BooksInDto inDto) {
        try {

            if (inDto == null || inDto.getId() == null || inDto.getId().isBlank()) {
                throw new IllegalArgumentException("ID가 누락되었습니다.");
            }
            
            return save(inDto);

        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("등록 중 예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("등록 실패", e);
        }
    }

    public BooksOutDto save(BooksInDto inDto) {
        try {
            Books book = null;
            if (!booksRepository.existsById(inDto.getId())) {
                inDto.setCreateDate(LocalDateTime.now());
                inDto.setUpdateDate(LocalDateTime.now());

                book = booksRepository.save(inDto.toEntity());
            }

            //Books book = booksRepository.getBooks(inDto.getId());
            if (book == null) {
                throw new IllegalStateException("등록된 ID에 해당하는 데이터가 존재하지 않습니다: " + inDto.getId());
            }

            return BooksOutDto.fromEntity(book);

        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("등록 중 예외 발생: " + e.getMessage());
            e.printStackTrace();

            // 필요 시 커스텀 예외 던지기
            throw new RuntimeException("등록 실패", e);
        }
    }

    public BooksOutDto getBooks(String id) {
        Books book = booksRepository.getBooks(id);
        if (book == null) {
            throw new IllegalArgumentException("해당 ID의 정보를 찾을 수 없습니다: " + id);
        }
        return BooksOutDto.fromEntity(book);
    }

    public BooksOutDto getBooks(BooksInDto inDto) {
        if (inDto == null || inDto.getId() == null || inDto.getId().isBlank()) {
            throw new IllegalArgumentException("ID가 누락되었습니다.");
        }
    
        BooksOutDto book = getBooks(inDto.getId());
        return book;
    }
    

    public String getBookId() {
        String genId;
        try {
            do {
                genId = idGeneratorType1();  // ID 생성
            } while (booksRepository.existsById("BOOK-" + genId));  // 존재하면 다시 생성
    
            return "BOOK-" + genId;
    
        } catch (Exception e) {
            // 로그 출력 (로그 라이브러리 사용 시 log.error(...)로 교체 가능)
            System.err.println("ID 생성 중 예외 발생: " + e.getMessage());
            e.printStackTrace();
    
            // 필요시 커스텀 예외 던지기
            throw new RuntimeException("ID 생성 실패", e);
        }
    }
    
    public String idGeneratorType1() {
        try {
            String date = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
            int random = new Random().nextInt(90000) + 10000; // 5자리 랜덤 숫자
            return date + "-" + random;
    
        } catch (IllegalArgumentException e) {
            // 포맷팅 관련 오류 처리
            System.err.println("날짜 포맷팅 오류: " + e.getMessage());
            throw new RuntimeException("날짜 포맷팅 오류", e);
        } catch (Exception e) {
            // 다른 예외 처리
            System.err.println("랜덤 숫자 생성 중 오류 발생: " + e.getMessage());
            throw new RuntimeException("ID 생성 실패", e);
        }
    }
    
}
