package com.bakerandboyle.library.infrastructure;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void testSaveAndFind() {
        Book book = BookBuilder.newBuilder()
                .withTitle("Title")
                .withAuthor("Author")
                .withGenre("Genre")
                .withIsbn("978-1-1234-5678").build();

        bookRepository.save(book);

        Book savedBook = bookRepository.findById(book.getId()).get();
        assertEquals(book.getTitle(), savedBook.getTitle());
        assertEquals(book.getAuthor(), savedBook.getAuthor());
        assertEquals(book.getGenre(), savedBook.getGenre());
    }

}