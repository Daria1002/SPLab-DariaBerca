package ro.uvt.info.designpatternslab2023.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL)
    private List<Element> content = new ArrayList<>();


    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addContent(Element element) {
        this.content.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("\nAuthors:");
        for (Author author : authors) {
            System.out.println("Author: " + author.getName());
        }
        System.out.println();
        for (Element element : content) {
            element.print();
        }
    }
}