package ro.uvt.info.designpatternslab2023.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.info.designpatternslab2023.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}