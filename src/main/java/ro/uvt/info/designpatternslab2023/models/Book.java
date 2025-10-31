package ro.uvt.info.designpatternslab2023.models;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private List<Author> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        super.add(element);
    }

    @Override
    public void print() {
        System.out.println("Book: " + super.title); // super.title e 'protected' sau avem un getter
        System.out.println();
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println();

        super.print();
    }
}