package mk.ukim.finki.wp.lab1wp.repository;

import mk.ukim.finki.wp.lab1wp.model.Author;
import mk.ukim.finki.wp.lab1wp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthor_Id(Long authorId);

    @Query("SELECT b FROM Book b WHERE " +
            "(:text IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :text, '%'))) AND " +
            "(:rating IS NULL OR b.averageRating >= :rating)")
    List<Book> searchBooks(@Param("text") String text, @Param("rating") Double rating);
}

