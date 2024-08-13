package com.bakerandboyle.library.utils;

import com.bakerandboyle.library.infrastructure.Book;
import com.bakerandboyle.library.model.BookDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtils {

    private TestUtils() {
    }

    public static void assertBooksEqual(List<Book> expectedBooks, List<Book> actualBooks) {
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

    public static void assertBookDTOsEqual(List<BookDTO> expectedBookDTOs, List<BookDTO> actualBookDTOs) {
        assertEquals(expectedBookDTOs.size(), actualBookDTOs.size());

        for (int i = 0; i < expectedBookDTOs.size(); i++) {
            BookDTO expectedBookDTO = expectedBookDTOs.get(i);
            BookDTO actualBookDTO = actualBookDTOs.get(i);

            assertEquals(expectedBookDTO.title(), actualBookDTO.title());
            assertEquals(expectedBookDTO.author(), actualBookDTO.author());
            assertEquals(expectedBookDTO.genre(), actualBookDTO.genre());
            assertEquals(expectedBookDTO.isbn(), actualBookDTO.isbn());
        }
    }
}
