package com.goods.gBooks.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goods.gBooks.books.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    boolean existsById(String id);
    
    @Query("SELECT b FROM Books b WHERE b.id = :id")
    Books getBooks(@Param("id") String id);
} 
