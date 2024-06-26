package com.drack.service;

import com.drack.persistence.entity.Author;
import com.drack.persistence.entity.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorService{

    List<Author> findAll();
    Optional findById(Long id);
    Author save(Author author);
    void deleteById(Long id);

}
