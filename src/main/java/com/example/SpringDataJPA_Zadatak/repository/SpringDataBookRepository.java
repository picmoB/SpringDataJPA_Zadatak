package com.example.SpringDataJPA_Zadatak.repository;

import com.example.SpringDataJPA_Zadatak.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataBookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    void deleteByIsbn(String isbn);
}
