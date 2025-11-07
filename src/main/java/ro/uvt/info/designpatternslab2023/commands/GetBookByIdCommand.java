package ro.uvt.info.designpatternslab2023.commands;

import ro.uvt.info.designpatternslab2023.models.Book;
import ro.uvt.info.designpatternslab2023.services.BookService;

public class GetBookByIdCommand implements Command<Book> {
    private final BookService bookService;
    private final Long bookId;

    public GetBookByIdCommand(BookService bookService, Long bookId) {
        this.bookService = bookService;
        this.bookId = bookId;
    }

    @Override
    public Book execute() {
        return bookService.getBookById(bookId);
    }
}