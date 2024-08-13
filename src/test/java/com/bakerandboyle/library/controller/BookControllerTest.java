package com.bakerandboyle.library.controller;

import com.bakerandboyle.library.model.BookDTO;
import com.bakerandboyle.library.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllBooks() throws Exception {
        List<BookDTO> bookDtos = List.of(
                new BookDTO("1","Book 1", "Author 1", "Genre 1", "ISBN 1"),
                new BookDTO("2", "Book 2", "Author 2", "Genre 2", "ISBN 2")
        );

        bookDtos.forEach(bookService::save);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(bookDtos.size())))
                .andExpect(jsonPath("$[0].title", is(bookDtos.get(0).title())))
                .andExpect(jsonPath("$[1].title", is(bookDtos.get(1).title())));
    }

    @Test
    void testAddBook() throws Exception {
        BookDTO bookDto = new BookDTO(null, "New Book", "Author", "Genre", "ISBN");

        mockMvc.perform(post("/books").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookDto)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("/books/")));
    }
}
