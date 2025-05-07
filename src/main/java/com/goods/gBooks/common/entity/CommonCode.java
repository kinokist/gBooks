package com.goods.gBooks.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "common_code")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonCode {
    @Id
    @Column(name = "code_group_id", length = 50)
    private String codeGroupId;

    @Column(name = "code_group_name", length = 100, nullable = false)
    private String codeGroupName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "use_yn", length = 1)
    private String useYn ;

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
