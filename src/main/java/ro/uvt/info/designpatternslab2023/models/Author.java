package ro.uvt.info.designpatternslab2023.models;

import java.util.Objects;

public class Author {
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}