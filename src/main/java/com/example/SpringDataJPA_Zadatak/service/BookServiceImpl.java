package com.example.SpringDataJPA_Zadatak.service;

import com.example.SpringDataJPA_Zadatak.domain.Book;
import com.example.SpringDataJPA_Zadatak.dto.BookDTO;
import com.example.SpringDataJPA_Zadatak.repository.SpringDataBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    //private BookService bookService;
    private final SpringDataBookRepository springDataBookRepository;

    @Override
    public List<BookDTO> findAll() {
        return springDataBookRepository.findAll().stream().map(BookDTO::new).collect(Collectors.toList());
    }

    @Override
    public Optional<BookDTO> findByIsbn(String isbn) {
        return springDataBookRepository.findByIsbn(isbn).map(BookDTO::new);
    }

    @Override
    public Optional<BookDTO> save(BookDTO bookDTO) {
        return Optional.of(new BookDTO(springDataBookRepository.save(new Book(bookDTO))));
    }

    @Override
    public Optional<BookDTO> update(String isbn, BookDTO updateBookDTO) {

        Optional<Book> bookDTOOptional = springDataBookRepository.findByIsbn(isbn);

        if (bookDTOOptional.isPresent()) {
            Book bookToUpdate = bookDTOOptional.get();
            bookToUpdate.setIsbn(updateBookDTO.getIsbn());
            bookToUpdate.setPrice(updateBookDTO.getPrice());
            bookToUpdate.setTitle(updateBookDTO.getTitle());
            return Optional.of(new BookDTO(springDataBookRepository.save(bookDTOOptional.get())));
        } else  {
            return Optional.empty();
        }
    }

    @Override
    public void deleteByIsbn(String isbn) {
        //springDataBookRepository.deleteByIsbn(isbn);
        springDataBookRepository.findByIsbn(isbn).ifPresent(springDataBookRepository::delete);
    }
}
