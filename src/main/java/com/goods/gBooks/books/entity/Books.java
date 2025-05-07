package com.goods.gBooks.books.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "gbooks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Books {

    @Id
    @Column(length = 50)
    private String id;

    @Column(length = 8, nullable = false)
    private String date;  // 'YYYYMMDD' 형식

    @Column(length = 50, nullable = false)
    private String app;

    @Column(name = "sales_type", length = 1, nullable = false)  // 'I': 매출, 'O': 매입
    private String salesType;

    @Column(length = 100, nullable = false)
    private String category;

    @Column(name = "start_area", length = 100, nullable = false)
    private String startArea;

    @Column(name = "arrive_area", length = 100, nullable = false)
    private String arriveArea;

    @Column(name = "receipt_type", length = 100, nullable = false)
    private String receiptType;

    @Column(name = "proof_status", length = 20, nullable = false)
    private String proofStatus;

    @Column(name = "account_due", nullable = false)
    private Boolean accountDue;  // true: 수금, false: 미수금

    @Column(name = "fare", nullable = false)
    private String fare;

    @Column(length = 100, nullable = false)
    private String client;

    @Column(columnDefinition = "TEXT")
    private String etc;

    @Column(columnDefinition = "user_id")
    private String userId;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = LocalDateTime.now();
    }
}
