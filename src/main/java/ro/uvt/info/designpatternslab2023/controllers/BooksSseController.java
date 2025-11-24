package ro.uvt.info.designpatternslab2023.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.info.designpatternslab2023.observer.AllBooksSubject;
import ro.uvt.info.designpatternslab2023.observer.SseObserver;

@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    @Autowired
    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @RequestMapping("/books-sse")
    public SseEmitter getBooksSse() {
        // Timeout-ul 0L înseamnă că Emitter-ul nu expiră niciodată
        final SseEmitter emitter = new SseEmitter(0L);

        // Creăm un nou observator pentru acest client specific
        SseObserver observer = new SseObserver(emitter, allBooksSubject);

        // Înregistrăm observatorul la subiect
        allBooksSubject.registerObserver(observer);

        // Gestionăm deconectarea sau erorile
        emitter.onCompletion(() -> allBooksSubject.unregisterObserver(observer));
        emitter.onTimeout(() -> allBooksSubject.unregisterObserver(observer));

        return emitter;
    }
}