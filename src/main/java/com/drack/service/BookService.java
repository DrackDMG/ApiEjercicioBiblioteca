package com.drack.service;

import com.drack.persistence.entity.repository.BookRepository;
import com.drack.persistence.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService{
    List<Book> findAll();
    Optional findById(Long id);
    Book save(Book book);
    void deleteById(Long id);
}
