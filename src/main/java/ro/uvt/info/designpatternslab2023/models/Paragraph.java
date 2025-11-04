package ro.uvt.info.designpatternslab2023.models;

public class Paragraph implements Element {
    private String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
        this.alignStrategy = null;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(this);
        } else {
            System.out.println("Paragraph: " + this.text);
        }
    }

    @Override
    public void add(Element element) { /* Nu e suportat */ }

    @Override
    public void remove(Element element) { /* Nu e suportat */ }

    @Override
    public Element get(int index) { /* Nu e suportat */ return null; }
}