package ro.uvt.info.designpatternslab2023.models;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private TableOfContents toc;
    private List<Author> authors = new ArrayList<>();
    private List<Chapter> chapters = new ArrayList<>();

    public Book(String title) {
        this.title = title;
        this.toc = new TableOfContents();
    }
    public void addAuthor(Author author) {
        authors.add(author);
    }
    public int createChapter(String chapterName) {
        Chapter chapter = new Chapter(chapterName);
        chapters.add(chapter);
        return chapters.indexOf(chapter);
    }
    public Chapter getChapter(int index) {
        return chapters.get(index);
    }
    public void print() {
        System.out.println("Book: " + title);
        System.out.println();

        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println();

        toc.print();
        System.out.println();

        for (Chapter chapter : chapters) {
            chapter.print();
        }
    }
}