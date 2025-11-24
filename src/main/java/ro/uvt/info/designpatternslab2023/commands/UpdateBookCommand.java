package ro.uvt.info.designpatternslab2023.commands;

import ro.uvt.info.designpatternslab2023.models.Book;
import ro.uvt.info.designpatternslab2023.services.BookService;

public class UpdateBookCommand implements Command<Book> {

    private final BookService bookService;
    private final Long bookId;
    private final Book bookDetails;

    public UpdateBookCommand(BookService bookService, Long bookId, Book bookDetails) {
        this.bookService = bookService;
        this.bookId = bookId;
        this.bookDetails = bookDetails;
    }

    @Override
    public Book execute() {
        return bookService.updateBook(bookId, bookDetails);
    }
}