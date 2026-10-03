package com.example.SpringDataJPA_Zadatak.domain;

import com.example.SpringDataJPA_Zadatak.dto.BookDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private int pages;
    private BigDecimal price;

    @ManyToOne
    //@JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book(BookDTO bookDTO) {
        this.title = bookDTO.getTitle();
        this.isbn = bookDTO.getIsbn();
        this.pages = bookDTO.getPages();
        this.price = bookDTO.getPrice();
        this.publisher = bookDTO.getPublisher();
    }
}
