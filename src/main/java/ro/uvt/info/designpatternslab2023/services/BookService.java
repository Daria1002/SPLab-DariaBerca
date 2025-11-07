package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2023.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public void addBook(Book book) {
        long newId = idCounter.incrementAndGet();
        book.setId(newId);
        books.add(book);
        System.out.println("BookService: S-a adăugat cartea: " + book);
    }

    public List<Book> getAllBooks() {
        System.out.println("BookService: Se returnează toate cărțile.");
        return new ArrayList<>(books);
    }

    public Book getBookById(Long id) {
        System.out.println("BookService: Se caută cartea cu ID: " + id);
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteBook(Long id) {
        System.out.println("BookService: Se șterge cartea cu ID: " + id);
        books.removeIf(book -> book.getId().equals(id));
    }
}