package ro.uvt.info.designpatternslab2023.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Paragraph extends BaseElement {
    private String text;

    @Transient
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        this.text = text;
        this.alignStrategy = null;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(this);
        } else {
            System.out.println("Paragraph: " + this.text);
        }
    }

    // Metodele add, remove, get sunt acum moștenite din BaseElement,
    // deci nu mai este nevoie să le scriem aici.
}