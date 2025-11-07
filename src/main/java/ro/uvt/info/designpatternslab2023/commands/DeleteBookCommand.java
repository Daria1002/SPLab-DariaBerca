package ro.uvt.info.designpatternslab2023.commands;

import ro.uvt.info.designpatternslab2023.services.BookService;

public class DeleteBookCommand implements Command<Void> {
    private final BookService bookService;
    private final Long bookId;

    public DeleteBookCommand(BookService bookService, Long bookId) {
        this.bookService = bookService;
        this.bookId = bookId;
    }

    @Override
    public Void execute() {
        bookService.deleteBook(bookId);
        return null;
    }
}