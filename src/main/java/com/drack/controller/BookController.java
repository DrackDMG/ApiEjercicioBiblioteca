package com.drack.controller;

import com.drack.persistence.entity.Book;
import com.drack.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> findById(@PathVariable Long id){
        Optional<Book> book = bookService.findById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book){
        Optional<Book> bookToUpdate =  bookService.findById(id);
        if (bookToUpdate.isPresent()) {
            bookToUpdate.get().setTitle(book.getTitle());
            bookToUpdate.get().setAuthorId(book.getAuthorId());
            bookToUpdate.get().setPublishedDate(book.getPublishedDate());
            bookToUpdate.get().setCode(book.getCode());
            return ResponseEntity.ok(bookService.save(bookToUpdate.orElse(null)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
