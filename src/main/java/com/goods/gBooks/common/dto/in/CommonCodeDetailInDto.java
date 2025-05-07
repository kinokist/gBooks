package com.goods.gBooks.common.dto.in;

import lombok.*;

import java.time.LocalDateTime;

import com.goods.gBooks.common.entity.CommonCodeDetail;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonCodeDetailInDto {

    private String codeId;
    private String codeGroupId;
    private String codeName;
    private String codeValue;
    private Integer sortOrder;
    private String useYn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommonCodeDetail toEntity() {
        return CommonCodeDetail.builder()
                .codeId(this.codeId)
                .codeGroupId(this.codeGroupId)
                .codeName(this.codeName)
                .codeValue(this.codeValue)
                .sortOrder(this.sortOrder != null ? this.sortOrder : 0)
                .useYn(this.useYn != null ? this.useYn : "Y")
                .createdAt(this.createdAt != null ? this.createdAt : LocalDateTime.now())
                .updatedAt(this.updatedAt != null ? this.updatedAt : LocalDateTime.now())
                .build();
    }
}
