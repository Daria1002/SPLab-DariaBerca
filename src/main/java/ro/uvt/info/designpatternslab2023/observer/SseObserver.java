package ro.uvt.info.designpatternslab2023.observer;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.designpatternslab2023.models.Book;

import java.io.IOException;

public class SseObserver implements Observer<Book> {

    private final SseEmitter emitter;
    private final Subject<Book> subject;

    public SseObserver(SseEmitter emitter, Subject<Book> subject) {
        this.emitter = emitter;
        this.subject = subject;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            System.err.println("Error sending SSE event: " + e.getMessage());
            subject.unregisterObserver(this);
            emitter.completeWithError(e);
        }
    }
}