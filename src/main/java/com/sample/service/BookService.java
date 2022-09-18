package com.sample.service;

import com.sample.exception.EntityNotFoundException;
import com.sample.model.Book;
import com.sample.persistence.BookRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityExistsException;
import java.util.NoSuchElementException;

@Component
public class BookService {

    private BookRepository repository;

    public BookService(final BookRepository repository) {
        this.repository = repository;
    }

    public Book findByTitle(final String title) {
        return this.repository.findByTitle(title)
                .orElseThrow(() -> new EntityNotFoundException(Book.class));
    }

    public Book save(final Book book) {
        return this.repository.save(book);
    }

    public Book update(final Book book) {
        this.repository.findById(book.getId())
                .orElseThrow(() -> new EntityNotFoundException(Book.class));
        return this.repository.save(book);
    }
}
