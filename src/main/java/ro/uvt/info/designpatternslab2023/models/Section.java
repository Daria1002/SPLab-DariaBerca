package ro.uvt.info.designpatternslab2023.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Section extends BaseElement {
    private String title;

    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Element> children = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println(title);
        for (Element child : children) {
            child.print();
        }
    }

    @Override
    public void add(Element element) {
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        children.remove(element);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }
}