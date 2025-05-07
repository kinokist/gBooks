package com.goods.gBooks.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goods.gBooks.common.entity.CommonCode;
import com.goods.gBooks.common.entity.CommonCodeDetail;

@Repository
public interface CommonCodeDetailRepository extends JpaRepository<CommonCodeDetail, Long> {
    boolean existsByCodeId(String codeId);

    CommonCodeDetail findByCodeId(String codeId);

    CommonCodeDetail findByCodeGroupId(String codeGroupId);

}
