package com.drack.service;

import com.drack.persistence.entity.repository.BookRepository;
import com.drack.persistence.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService extends BookRepository {
    List<Book> findAll();
    Optional findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
}
