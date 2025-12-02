package mk.ukim.finki.wp.lab1wp.repository;

import mk.ukim.finki.wp.lab1wp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
