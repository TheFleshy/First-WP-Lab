package mk.ukim.finki.wp.firstlab.repository;

import java.util.List;
import mk.ukim.finki.wp.firstlab.model.Book;

public interface BookRepository {
    List<Book> findAll();
    List<Book> searchBooks(String text, Double rating);
}
