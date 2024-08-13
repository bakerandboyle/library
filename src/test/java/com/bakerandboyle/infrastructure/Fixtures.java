package com.bakerandboyle.infrastructure;

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
}
