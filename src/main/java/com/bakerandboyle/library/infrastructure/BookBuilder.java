package com.bakerandboyle.library.infrastructure;

public class BookBuilder {

    private String title;
    private String author;
    private String genre;
    private String isbn;

    public static BookBuilder newBuilder() {
        return new BookBuilder();
    }

    public BookBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder withAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public BookBuilder withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Book build() {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setIsbn(isbn);
        return book;
    }
}
