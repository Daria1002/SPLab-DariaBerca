package ro.uvt.info.designpatternslab2023.commands;
public interface Command<T> {
    T execute();
}