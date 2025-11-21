package ro.uvt.info.designpatternslab2023.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2023.models.Book;
import ro.uvt.info.designpatternslab2023.persistence.BookRepository; // Importă BookRepository

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookRepository bookRepository;

    @Autowired
    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        return bookOptional
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK)) // Dacă a fost găsită, returnează cartea
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Altfel, returnează 404 Not Found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return new ResponseEntity<>("Cartea a fost ștearsă.", HttpStatus.OK);
    }

}