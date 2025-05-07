package com.goods.gBooks.common.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "common_code_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonCodeDetail {

    @Id
    @Column(name = "code_id", length = 50)
    private String codeId;

    @Column(name = "code_group_id", length = 50, nullable = false)
    private String codeGroupId;

    @Column(name = "code_name", length = 100, nullable = false)
    private String codeName;

    @Column(name = "code_value", length = 100, nullable = false)
    private String codeValue;

    @Column(name = "sort_order")
    private Integer sortOrder = 0;

    @Column(name = "use_yn", length = 1)
    private String useYn = "Y";

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
