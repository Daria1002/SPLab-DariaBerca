package ro.uvt.info.designpatternslab2023.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();


    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }
}