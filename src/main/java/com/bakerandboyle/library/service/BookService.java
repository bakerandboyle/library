package com.bakerandboyle.library.service;

import com.bakerandboyle.library.infrastructure.Book;
import com.bakerandboyle.library.infrastructure.BookRepository;
import com.bakerandboyle.library.model.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final BookTransformer bookTransformer;

    public BookService(BookRepository bookRepository, BookTransformer bookTransformer) {
        this.bookRepository = bookRepository;
        this.bookTransformer = bookTransformer;
    }

    public Book save(BookDTO bookDto) {
        return Optional.ofNullable(bookDto)
                .map(bookTransformer::toBook)
                .map(bookRepository::save)
                .orElseThrow(() -> new IllegalArgumentException("BookDTO cannot be null"));
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookTransformer::toBookDTO)
                .collect(Collectors.toList());
    }

}
