package com.example.SpringDataJPA_Zadatak.dto;

import com.example.SpringDataJPA_Zadatak.domain.Book;
import com.example.SpringDataJPA_Zadatak.domain.Publisher;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private String title;
    private String isbn;
    private int pages;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public BookDTO(BookDTO bookDTO) {
        this.title = bookDTO.getTitle();
        this.isbn = bookDTO.getIsbn();
        this.pages = bookDTO.getPages();
        this.price = bookDTO.getPrice();
        this.publisher = bookDTO.getPublisher();
    }

    public BookDTO(Book book) {
        this.title = book.getTitle();
        this.isbn = book.getIsbn();
        this.pages = book.getPages();
        this.price = book.getPrice();
        this.publisher = book.getPublisher();
    }
}
