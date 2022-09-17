package com.sample.service;

import com.sample.model.Book;
import com.sample.persistence.BookRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityExistsException;

@Component
public class BookService {

    private BookRepository repository;

    public BookService(final BookRepository repository) {
        this.repository = repository;
    }

    public Book findByTitle(final String title) {
        return this.repository.findByTitle(title)
                .orElseThrow(EntityExistsException::new);
    }

    public Book save(final Book book) {
        return this.repository.save(book);
    }

}
