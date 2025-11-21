package ro.uvt.info.designpatternslab2023.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class BaseElement implements Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Aici putem adăuga metodele comune din interfața Element
    // pe care nu le vom implementa în clasele concrete care nu le suportă

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException();
    }
}