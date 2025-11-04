package ro.uvt.info.designpatternslab2023.commands;

import ro.uvt.info.designpatternslab2023.models.Book;
import ro.uvt.info.designpatternslab2023.services.BookService;

public class AddBookCommand implements Command<Void> {
    private final Book book;
    private final BookService bookService;

    public AddBookCommand(Book book, BookService bookService) {
        this.book = book;
        this.bookService = bookService;
    }

    @Override
    public Void execute() {
        bookService.addBook(book);
        return null;
    }
}