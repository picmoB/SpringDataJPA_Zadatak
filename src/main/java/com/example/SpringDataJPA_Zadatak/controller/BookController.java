package com.example.SpringDataJPA_Zadatak.controller;

import com.example.SpringDataJPA_Zadatak.dto.BookDTO;
import com.example.SpringDataJPA_Zadatak.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/find/{isbn}")
    public Optional<BookDTO> findByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }

    @PostMapping("/new")
    public Optional<BookDTO> save(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }

    @PutMapping("/update/{isbn}")
    public Optional<BookDTO> update(@RequestBody BookDTO bookDTO, @PathVariable String isbn) {
        //return bookService.findByIsbn(isbn).map(BookDTO::new);
        return bookService.update(isbn, bookDTO).map(BookDTO::new);
    }

    @DeleteMapping("/delete/{isbn}")
    public void deleteByIsbn(@PathVariable String isbn) {
        bookService.deleteByIsbn(isbn);
    }
}
