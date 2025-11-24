package ro.uvt.info.designpatternslab2023.observer;

public interface Observer<T> {
    void update(T data);
}