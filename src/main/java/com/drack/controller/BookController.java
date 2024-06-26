package com.drack.controller;

import com.drack.persistence.entity.Book;
import com.drack.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Book> findById(@PathVariable Long id){
        Book book = bookService.findById(id);
        if(book == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book){
        Book bookToUpdate = bookService.findById(id);
        if(bookToUpdate == null){
            return ResponseEntity.notFound().build();
        }
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthorId(book.getAuthorId());
        bookToUpdate.setPublishedDate(book.getPublishedDate());
        bookToUpdate.setCode(book.getCode());
        return ResponseEntity.ok(bookService.save(bookToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
