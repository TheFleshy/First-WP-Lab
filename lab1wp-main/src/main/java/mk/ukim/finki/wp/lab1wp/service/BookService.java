package mk.ukim.finki.wp.lab1wp.service;

import mk.ukim.finki.wp.lab1wp.model.Author;
import mk.ukim.finki.wp.lab1wp.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);

    Book save(String title, String genre, double rating, Author author);

    Book update(Long id, String title, String genre, double rating, Author author);

    void delete(Long id);

    Optional<Book> findById(Long id);
}
