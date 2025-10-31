package ro.uvt.info.designpatternslab2023.models;

public class Image implements Element {
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + this.imageName);
    }

    @Override
    public void add(Element element) { /* Nu e suportat */ }

    @Override
    public void remove(Element element) { /* Nu e suportat */ }

    @Override
    public Element get(int index) { /* Nu e suportat */ return null; }
}