package com.bakerandboyle.library.infrastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookBuilderTest {
    @Test
    void testBuilderWithNoId() {
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

    @Test
    void testBuilderWithId() {
        Book book = BookBuilder.newBuilder()
                .withId("1")
                .withTitle("Test Book")
                .withAuthor("Author")
                .withGenre("Genre")
                .withIsbn("ISBN")
                .build();

        assertEquals(1, book.getId());
        assertEquals("Test Book", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Genre", book.getGenre());
        assertEquals("ISBN", book.getIsbn());
    }

}