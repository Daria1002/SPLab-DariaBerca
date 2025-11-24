package ro.uvt.info.designpatternslab2023.observer;

import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject implements Subject<Book> {

    private final List<Observer<Book>> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer<Book> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer<Book> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer<Book> observer : observers) {
            observer.update(book);
        }
    }
}