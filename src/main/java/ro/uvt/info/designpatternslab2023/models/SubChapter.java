package ro.uvt.info.designpatternslab2023.models;

import java.util.ArrayList;
import java.util.List;

public class SubChapter {
    private String name;
    private List<Paragraph> paragraphs = new ArrayList<>();
    private List<Image> images = new ArrayList<>();
    private List<Table> tables = new ArrayList<>();

    public SubChapter(String name) {
        this.name = name;
    }
    public void createNewParagraph(String text) {
        paragraphs.add(new Paragraph(text));
    }
    public void createNewImage(String imageName) {
        images.add(new Image(imageName));
    }
    public void createNewTable(String title) {
        tables.add(new Table(title));
    }
    public void print() {
        System.out.println("Subchapter: " + name);
        for (Paragraph p : paragraphs) {
            p.print();
        }
        for (Image i : images) {
            i.print();
        }
        for (Table t : tables) {
            t.print();
        }
    }
}