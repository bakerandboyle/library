package com.bakerandboyle.library.infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testSaveAndFind() {
        Book book = BookBuilder.newBuilder()
                .withTitle("Title")
                .withAuthor("Author")
                .withGenre("Genre")
                .withIsbn("978-1-1234-5678").build();

        bookRepository.save(book);

        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        Book savedBook = optionalBook.orElseThrow();
        assertEquals(book.getTitle(), savedBook.getTitle());
        assertEquals(book.getAuthor(), savedBook.getAuthor());
        assertEquals(book.getGenre(), savedBook.getGenre());
    }

}