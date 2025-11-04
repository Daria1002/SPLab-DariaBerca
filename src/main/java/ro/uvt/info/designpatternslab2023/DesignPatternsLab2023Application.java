package ro.uvt.info.designpatternslab2023;

import ro.uvt.info.designpatternslab2023.models.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsLab2023Application {

    // In fisierul: DesignPatternsLab2023Application.java
    public static void main(String[] args) throws Exception {

        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        Paragraph p2 = new Paragraph("Paragraph 2");
        Paragraph p3 = new Paragraph("Paragraph 3");
        Paragraph p4 = new Paragraph("Paragraph 4");

        cap1.add(p1);
        cap1.add(p2);
        cap1.add(p3);
        cap1.add(p4);

        System.out.println("Printing without Alignment");
        System.out.println();
        cap1.print();
        System.out.println();

        p1.setAlignStrategy(new AlignCenter());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignLeft());

        System.out.println("Printing with Alignment");
        System.out.println();
        cap1.print();
    }
}