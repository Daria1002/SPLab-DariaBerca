package ro.uvt.info.designpatternslab2023.models;

public class Paragraph implements Element {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + this.text);
    }

    @Override
    public void add(Element element) { /* Nu e suportat */ }

    @Override
    public void remove(Element element) { /* Nu e suportat */ }

    @Override
    public Element get(int index) { /* Nu e suportat */ return null; }
}