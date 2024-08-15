package com.bakerandboyle.library.service;

import com.bakerandboyle.library.fixtures.Fixtures;
import com.bakerandboyle.library.infrastructure.Book;
import com.bakerandboyle.library.infrastructure.BookRepository;
import com.bakerandboyle.library.model.BookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static com.bakerandboyle.library.utils.TestUtils.assertBookDTOsEqual;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {
    @MockBean
    private BookRepository mockBookRepository;

    @MockBean
    private BookTransformer mockBookTransformer;

    @Autowired
    private BookService bookService;


    @Test
    void testSave() {
        when(mockBookTransformer.toBook(Fixtures.aBookDTOWithoutId())).thenReturn(Fixtures.aBookWithoutId());
        when(mockBookRepository.save(Fixtures.aBookWithoutId())).thenReturn(Fixtures.aBook());
        Book savedBook = bookService.save(Fixtures.aBookDTOWithoutId());
        assertEquals(1L, savedBook.getId());
        assertEquals("Test Book", savedBook.getTitle());
        assertEquals("Author", savedBook.getAuthor());
        assertEquals("Genre", savedBook.getGenre());
        assertEquals("9871444555", savedBook.getIsbn());
    }

    @Test
    void testFindAllWhenThereAreNoBooks() {
        when(mockBookRepository.findAll()).thenReturn(new ArrayList<>());

        List<BookDTO> allBooks = bookService.getAllBooks();

        assertEquals(0, allBooks.size());
    }

    @Test
    void testFindAllBooks() {
        when(mockBookTransformer.toBookDTO(any())).thenReturn(
                Fixtures.bookDTOs().get(0),
                Fixtures.bookDTOs().get(1),
                Fixtures.bookDTOs().get(2),
                Fixtures.bookDTOs().get(3),
                Fixtures.bookDTOs().get(4)
        );
        when(mockBookRepository.findAll()).thenReturn(Fixtures.books());

        List<BookDTO> allBooks = bookService.getAllBooks();

        assertBookDTOsEqual(Fixtures.bookDTOs(), allBooks);

    }
}