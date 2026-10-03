package com.example.SpringDataJPA_Zadatak.service;

import com.example.SpringDataJPA_Zadatak.domain.Book;
import com.example.SpringDataJPA_Zadatak.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<BookDTO> findAll();
    Optional<BookDTO> findByIsbn(String isbn);
    Optional<BookDTO> save(BookDTO bookDTO);
    Optional<BookDTO> update(String isbn, BookDTO updateBookDTO);
    void deleteByIsbn(String isbn);
}
