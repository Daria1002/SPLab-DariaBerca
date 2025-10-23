package ro.uvt.info.designpatternslab2023.models;
public class Author {
    private String name;
    public Author(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println("Author: " + this.name);
    }
}