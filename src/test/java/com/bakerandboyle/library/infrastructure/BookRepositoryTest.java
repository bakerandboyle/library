package com.bakerandboyle.library.infrastructure;

import com.bakerandboyle.infrastructure.Fixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
        bookRepository.saveAll(Fixtures.books());
    }

    @Test
    void testSaveAndFind() {
        Book book = BookBuilder.newBuilder()
                .withTitle("The Great Gatsby")
                .withAuthor("F. Scott Fitzgerald")
                .withGenre("Classic")
                .withIsbn("9780743273569")
                .build();

        bookRepository.save(book);

        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        Book savedBook = optionalBook.orElseThrow();
        assertEquals(book.getTitle(), savedBook.getTitle());
        assertEquals(book.getAuthor(), savedBook.getAuthor());
        assertEquals(book.getGenre(), savedBook.getGenre());
    }

    @Test
    void testListAll() {
        List<Book> listOfBooks = bookRepository.findAll();

        assertEquals(Fixtures.books().size(), listOfBooks.size());
        assertBooksEqual(Fixtures.books(), listOfBooks);
    }

    private void assertBooksEqual(List<Book> expectedBooks, List<Book> actualBooks) {
        assertEquals(expectedBooks.size(), actualBooks.size());
        for (int i = 0; i < expectedBooks.size(); i++) {
            Book expectedBook = expectedBooks.get(i);
            Book actualBook = actualBooks.get(i);

            assertEquals(expectedBook.getTitle(), actualBook.getTitle());
            assertEquals(expectedBook.getAuthor(), actualBook.getAuthor());
            assertEquals(expectedBook.getGenre(),
                    actualBook.getGenre());
            assertEquals(expectedBook.getIsbn(),
                    actualBook.getIsbn());
        }

    }
}