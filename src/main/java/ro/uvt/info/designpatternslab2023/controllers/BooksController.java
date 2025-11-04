package ro.uvt.info.designpatternslab2023.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2023.models.Book;

@RestController
@RequestMapping("/books")
public class BooksController {

    @GetMapping
    public ResponseEntity<String> getAllBooks() {
        System.out.println("BooksController: se cer toate cartile...");
        return new ResponseEntity<>("toate cartile vor fi afisate aici", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        System.out.println("BooksController: se creeaza o carte...");
        return new ResponseEntity<>("cartea '" + book.getTitle() + "' va fi creata", HttpStatus.CREATED);
    }
}