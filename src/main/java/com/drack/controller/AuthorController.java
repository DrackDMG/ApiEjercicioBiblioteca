package com.drack.controller;

import com.drack.persistence.entity.Author;
import com.drack.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> findAll(){
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> findById(@PathVariable Long id){
        Optional<Author> author = authorService.findById(id);
        if (author.isPresent()) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Author> save(@RequestBody Author author){
        return ResponseEntity.ok(authorService.save(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable Long id, @RequestBody Author author){
        Optional<Author> authorToUpdate =  authorService.findById(id);
        if (authorToUpdate.isPresent()) {
            authorToUpdate.get().setName(author.getName());
            authorToUpdate.get().setCountry(author.getCountry());
            authorToUpdate.get().setBirthDate(author.getBirthDate());
            return ResponseEntity.ok(authorService.save(authorToUpdate.orElse(null)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
