package com.sample.rest.controller;

import com.sample.dto.BookDTO;
import com.sample.dto.BookPostMethodDTO;
import com.sample.http.BasicResponse;
import com.sample.model.Book;
import com.sample.rest.api.BookApi;
import com.sample.service.BookService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController implements BookApi {

    private BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public BasicResponse<BookDTO> getBookByTitle(final String title) {
        final Book book = this.bookService.findByTitle(title);
        return BasicResponse.success(BookDTO.ofEntity(book));
    }

    @Override
    public BasicResponse<BookDTO> postBook(final BookPostMethodDTO book) {
        final Book persistedBook = this.bookService.save(book.toEntity());
        return BasicResponse.success(BookDTO.ofEntity(persistedBook));
    }

    @Override
    public BasicResponse<BookDTO> putBook(final BookDTO book) {
        final Book persistedBook = this.bookService.update(book.toEntity());
        return BasicResponse.success(BookDTO.ofEntity(persistedBook));
    }

}
