package com.bakerandboyle.library.service;

import com.bakerandboyle.library.fixtures.Fixtures;
import com.bakerandboyle.library.infrastructure.Book;
import com.bakerandboyle.library.model.BookDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BookTransformerTest {

    private final BookTransformer bookTransformer = new BookTransformer();

    @Test
    void testToBookWithNullId() {

        Book book = bookTransformer.toBook(Fixtures.aBookDTOWithoutId());

        assertNull(book.getId());
        assertEquals(Fixtures.aBookDTOWithoutId().title(), book.getTitle());
        assertEquals(Fixtures.aBookDTOWithoutId().author(), book.getAuthor());
        assertEquals(Fixtures.aBookDTOWithoutId().genre(), book.getGenre());
        assertEquals(Fixtures.aBookDTOWithoutId().isbn(), book.getIsbn());
    }

    @Test
    void testToBookWithId() {

        Book book = bookTransformer.toBook(Fixtures.aBookDTO());

        assertEquals(Long.parseLong(Fixtures.aBookDTO().id()), book.getId());
        assertEquals(Fixtures.aBookDTO().title(), book.getTitle());
        assertEquals(Fixtures.aBookDTO().author(), book.getAuthor());
        assertEquals(Fixtures.aBookDTO().genre(), book.getGenre());
        assertEquals(Fixtures.aBookDTO().isbn(), book.getIsbn());
    }

    @Test
    void testToBookDTO() {
        BookDTO bookDto = bookTransformer.toBookDTO(Fixtures.aBook());

        assertEquals(String.valueOf(Fixtures.aBook().getId()), bookDto.id());
        assertEquals(Fixtures.aBook().getTitle(), bookDto.title());
        assertEquals(Fixtures.aBook().getAuthor(), bookDto.author());
        assertEquals(Fixtures.aBook().getGenre(), bookDto.genre());
        assertEquals(Fixtures.aBook().getIsbn(), bookDto.isbn());
    }

}