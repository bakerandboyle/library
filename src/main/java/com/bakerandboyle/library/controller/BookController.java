package com.bakerandboyle.library.controller;

import com.bakerandboyle.library.infrastructure.Book;
import com.bakerandboyle.library.model.BookDTO;
import com.bakerandboyle.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookDtos = bookService.getAllBooks();
        return ResponseEntity.ok(bookDtos);
    }

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDto) {
        Book book = bookService.save(bookDto);
        return ResponseEntity.created(URI.create("/books/" + book.getId()))
                .body(bookDto);
    }
}
