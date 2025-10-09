package models;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String name;
    private List<SubChapter> subChapters = new ArrayList<>();

    public Chapter(String name) {
        this.name = name;
    }
    public int createSubChapter(String subChapterName) {
        SubChapter newSubChapter = new SubChapter(subChapterName);
        subChapters.add(newSubChapter);
        return subChapters.indexOf(newSubChapter);
    }
    public SubChapter getSubChapter(int index) {
        return subChapters.get(index);
    }
    public void print() {
        System.out.println("Chapter: " + name);
        for (SubChapter sc : subChapters) {
            sc.print();
        }
    }
}