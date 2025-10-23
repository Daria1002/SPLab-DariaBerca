package ro.uvt.info.designpatternslab2023;

// Importăm toate clasele de care avem nevoie
import ro.uvt.info.designpatternslab2023.models.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternsLab2023Application {

    public static void main(String[] args) {
        // Linia de mai jos pornește aplicația Spring. O comentăm, cum scrie în laborator.
        // SpringApplication.run(DesignPatternsLab2023Application.class, args);
        Book discoTitanic = new Book("Disco Titanic");
        discoTitanic.addAuthor(new Author("Radu Pavel Gheo"));

        // 3. Creăm un capitol
        int indexChapterOne = discoTitanic.createChapter("Capitolul 1");
        Chapter chp1 = discoTitanic.getChapter(indexChapterOne);

        // 4. Creăm un subcapitol
        int indexSubChapterOne = chp1.createSubChapter("Subcapitolul 1.1");
        SubChapter scOneOne = chp1.getSubChapter(indexSubChapterOne);

        // 5. Adăugăm conținut în subcapitol
        scOneOne.createNewParagraph("Acesta este un paragraf pentru carte.");
        scOneOne.createNewImage("imagine_coperta.jpg");
        scOneOne.createNewTable("Tabelul cu personaje");

        // 6. La final, cerem cărții să se printeze în consolă
        discoTitanic.print();
    }
}