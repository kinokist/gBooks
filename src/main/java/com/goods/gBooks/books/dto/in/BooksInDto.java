package com.goods.gBooks.books.dto.in;

import java.time.LocalDateTime;

import com.goods.gBooks.books.entity.Books;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BooksInDto {
    private String id; 
    private String date; // YYYYMMDD 형식 문자열
    private String app;
    private String salesType; // 'I' 또는 'O'
    private String category;
    private String startArea;
    private String arriveArea;
    private String receiptType;
    private String proofStatus;
    private Boolean accountDue; // true(수금), false(미수금)
    private String fare;
    private String client;
    private String etc;
    private String userId;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Books toEntity() {
        return Books.builder()
                .id(this.id)
                .date(this.date)
                .app(this.app)
                .salesType(this.salesType)
                .category(this.category)
                .startArea(this.startArea)
                .arriveArea(this.arriveArea)
                .receiptType(this.receiptType)
                .proofStatus(this.proofStatus)
                .accountDue(this.accountDue)
                .fare(this.fare)
                .client(this.client)
                .etc(this.etc)
                .userId(this.userId)
                .createDate(this.createDate)
                .updateDate(this.updateDate)
                .build();
    }
}
