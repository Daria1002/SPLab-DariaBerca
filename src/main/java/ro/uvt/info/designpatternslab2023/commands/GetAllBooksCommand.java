package ro.uvt.info.designpatternslab2023.commands;

import ro.uvt.info.designpatternslab2023.models.Book;
import ro.uvt.info.designpatternslab2023.services.BookService;
import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    private final BookService bookService;

    public GetAllBooksCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public List<Book> execute() {
        return bookService.getAllBooks();
    }
}