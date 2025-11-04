package ro.uvt.info.designpatternslab2023.services;

import org.springframework.stereotype.Service;
import ro.uvt.info.designpatternslab2023.models.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("BookService: S-a adăugat cartea: " + book.getTitle());
    }

    public List<Book> getAllBooks() {
        System.out.println("BookService: Se returnează toate cărțile.");
        return new ArrayList<>(books); // Returnăm o copie pentru siguranță
    }
}