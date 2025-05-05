package com.goods.gBooks.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goods.gBooks.books.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    boolean existsById(String id);
} 
