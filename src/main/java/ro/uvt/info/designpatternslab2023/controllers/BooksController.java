package ro.uvt.info.designpatternslab2023.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.info.designpatternslab2023.commands.*;
import ro.uvt.info.designpatternslab2023.models.Book;
import ro.uvt.info.designpatternslab2023.observer.AllBooksSubject;
import ro.uvt.info.designpatternslab2023.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final AllBooksSubject allBooksSubject;

    @Autowired
    public BooksController(BookService bookService, AllBooksSubject allBooksSubject) {
        this.bookService = bookService;
        this.allBooksSubject = allBooksSubject;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);

        allBooksSubject.notifyObservers(savedBook);

        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        Command<List<Book>> command = new GetAllBooksCommand(bookService);
        List<Book> books = command.execute();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Command<Book> command = new GetBookByIdCommand(bookService, id);
        Book book = command.execute();
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        try {
            Command<Book> command = new UpdateBookCommand(bookService, id, bookDetails);
            Book updatedBook = command.execute();
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Command<Void> command = new DeleteBookCommand(bookService, id);
        command.execute();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}