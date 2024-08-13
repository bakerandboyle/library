package com.bakerandboyle.library.service;

import com.bakerandboyle.library.infrastructure.Book;
import com.bakerandboyle.library.model.BookDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BookTransformerTest {

    private final BookTransformer bookTransformer = new BookTransformer();

    @Test
    void testToBookWithNullId() {

        BookDTO bookDTO = new BookDTO(null, "Test Book", "Author", "Genre", "ISBN");
        Book book = bookTransformer.toBook(bookDTO);

        assertNull(book.getId());
        assertEquals("Test Book", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Genre", book.getGenre());
        assertEquals("ISBN", book.getIsbn());
    }

    @Test
    void testToBookWithId() {

        BookDTO bookDTO = new BookDTO("1", "Test Book", "Author", "Genre", "ISBN");
        Book book = bookTransformer.toBook(bookDTO);

        assertEquals(1L, book.getId());
        assertEquals("Test Book", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Genre", book.getGenre());
        assertEquals("ISBN", book.getIsbn());
    }
}