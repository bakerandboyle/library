package com.bakerandboyle.library.service;

import com.bakerandboyle.library.infrastructure.Book;
import com.bakerandboyle.library.infrastructure.BookBuilder;
import com.bakerandboyle.library.model.BookDTO;
import org.springframework.stereotype.Component;

@Component
public class BookTransformer {
    public Book toBook(BookDTO bookDto) {
        return BookBuilder.newBuilder()
                .withId(bookDto.id())
                .withTitle(bookDto.title())
                .withAuthor(bookDto.author())
                .withGenre(bookDto.genre())
                .withIsbn(bookDto.isbn())
                .build();
    }

    public BookDTO toBookDTO(Book book) {
        return new BookDTO(String.valueOf(book.getId()), book.getTitle(), book.getAuthor(), book.getGenre(), book.getIsbn());
    }
}
