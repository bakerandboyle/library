package com.bakerandboyle.library.infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookBuilderTest {
    @Test
    void testBuilder() {
        Book book = BookBuilder.newBuilder()
                .withTitle("Test Book")
                .withAuthor("Author")
                .withGenre("Genre")
                .withIsbn("ISBN")
                .build();

        assertEquals("Test Book", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Genre", book.getGenre());
        assertEquals("ISBN", book.getIsbn());
    }

}