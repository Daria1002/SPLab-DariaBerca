package ro.uvt.info.designpatternslab2023.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.uvt.info.designpatternslab2023.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}