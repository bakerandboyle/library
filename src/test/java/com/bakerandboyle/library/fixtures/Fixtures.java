package com.bakerandboyle.library.fixtures;

import com.bakerandboyle.library.infrastructure.Book;
import com.bakerandboyle.library.infrastructure.BookBuilder;
import com.bakerandboyle.library.model.BookDTO;

import java.util.List;

public class Fixtures {

    private static final List<Book> BOOKS = List.of(
            BookBuilder.newBuilder()
                    .withTitle("To Kill a Mockingbird")
                    .withAuthor("Harper Lee")
                    .withGenre("Fiction")
                    .withIsbn("9780060735256")
                    .build(),
            BookBuilder.newBuilder()
                    .withTitle("1984")
                    .withAuthor("George Orwell")
                    .withGenre("Dystopian")
                    .withIsbn("9780451534852")
                    .build(),
            BookBuilder.newBuilder()
                    .withTitle("Pride and Prejudice")
                    .withAuthor("Jane Austen")
                    .withGenre("Romance")
                    .withIsbn("9780553353356")
                    .build(),
            BookBuilder.newBuilder()
                    .withTitle("The Lord of the Rings")
                    .withAuthor("J.R.R. Tolkien")
                    .withGenre("Fantasy")
                    .withIsbn("9780395026467")
                    .build(),
            BookBuilder.newBuilder()
                    .withTitle("The Hitchhiker's Guide to the Galaxy")
                    .withAuthor("Douglas Adams")
                    .withGenre("Science Fiction")
                    .withIsbn("9780575031207")
                    .build()
    );

    public static List<Book> books() {
        return BOOKS;
    }

    public static Book aBookWithoutId() {
        return BookBuilder.newBuilder()
                .withTitle("Test Book")
                .withAuthor("Author")
                .withGenre("Genre")
                .withIsbn("9871444555")
                .build();
    }

    public static Book aBook() {
        return BookBuilder.newBuilder()
                .withId("1")
                .withTitle("Test Book")
                .withAuthor("Author")
                .withGenre("Genre")
                .withIsbn("9871444555")
                .build();
    }

    public static BookDTO aBookDTOWithoutId() {
        return new BookDTO(null, "Test Book", "Author", "Genre", "9871444555");
    }

    public static BookDTO aBookDTO() {
        return new BookDTO("1", "Test Book", "Author", "Genre", "9871444555");
    }

    private static final List<BookDTO> BOOK_DTOS = List.of(
            new BookDTO("1", "To Kill a Mockingbird", "Harper Lee", "Fiction", "9780060735256"),
            new BookDTO("2", "1984", "George Orwell", "Dystopian", "9780451534852"),
            new BookDTO("3", "Pride and Prejudice", "Jane Austen", "Romance", "9780553353356"),
            new BookDTO("4", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "9780395026467"),
            new BookDTO("5", "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction", "9780575031207")
    );

    public static List<BookDTO> bookDTOs() {
        return BOOK_DTOS;
    }
}
