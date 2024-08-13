package com.bakerandboyle.library.service;

import com.bakerandboyle.infrastructure.Fixtures;
import com.bakerandboyle.library.infrastructure.Book;
import com.bakerandboyle.library.infrastructure.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    @Mock
    private BookRepository mockBookRepository;

    @Autowired
    private BookService bookService;

    @Test
    void testSave() {
        when(mockBookRepository.save(Fixtures.aBookWithoutId())).thenReturn(Fixtures.aBook());
        Book savedBook = bookService.save(Fixtures.aBookDTOWithoutId());
        assertEquals(1L, savedBook.getId());
        assertEquals("Test Book", savedBook.getTitle());
        assertEquals("Author", savedBook.getAuthor());
        assertEquals("Genre", savedBook.getGenre());
        assertEquals("9871444555", savedBook.getIsbn());
    }
}