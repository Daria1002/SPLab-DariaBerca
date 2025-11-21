package ro.uvt.info.designpatternslab2023.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Image extends BaseElement {
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + this.imageName);
    }

}