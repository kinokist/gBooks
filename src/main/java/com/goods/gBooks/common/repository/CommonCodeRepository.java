package com.goods.gBooks.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goods.gBooks.books.entity.Books;
import com.goods.gBooks.common.entity.CommonCode;

@Repository
public interface CommonCodeRepository extends JpaRepository<CommonCode, Long> {
    boolean existsByCodeGroupId(String codeGroupId);

    CommonCode findByCodeGroupId(String codeGroupId);
    
}
