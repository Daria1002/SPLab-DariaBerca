package ro.uvt.info.designpatternslab2023.models;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph) {
        // Simulam alinierea la centru adaugand spatii in fata.
        System.out.println("     Paragraph: " + paragraph.getText());
    }
}