package ro.uvt.info.designpatternslab2023.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.uvt.info.designpatternslab2023.models.Book;
import ro.uvt.info.designpatternslab2023.persistence.BookRepository;

import java.util.List;
import java.util.Optional;

@Component
public class BookRepositoryAdapter implements CrudRepository<Book, Long> {

    private final BookRepository jpaRepository;

    @Autowired
    public BookRepositoryAdapter(BookRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Book save(Book entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public List<Book> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}