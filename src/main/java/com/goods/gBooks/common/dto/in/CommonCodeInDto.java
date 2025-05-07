package com.goods.gBooks.common.dto.in;

import lombok.*;

import java.time.LocalDateTime;

import com.goods.gBooks.common.entity.CommonCode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonCodeInDto {

    private String codeGroupId;
    private String codeGroupName;
    private String description;
    private String useYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommonCode toEntity() {
        return CommonCode.builder()
                .codeGroupId(this.codeGroupId)
                .codeGroupName(this.codeGroupName)
                .description(this.description)
                .useYn(this.useYn != null ? this.useYn : "Y")
                .createdAt(this.createdAt != null ? this.createdAt : LocalDateTime.now())
                .updatedAt(this.updatedAt != null ? this.updatedAt : LocalDateTime.now())
                .build();
    }
}
