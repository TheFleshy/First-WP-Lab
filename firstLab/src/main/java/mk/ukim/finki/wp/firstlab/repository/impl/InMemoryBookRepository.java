package mk.ukim.finki.wp.firstlab.repository.impl;

import mk.ukim.finki.wp.firstlab.repository.BookRepository;
import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.firstlab.model.Book;
import mk.ukim.finki.wp.firstlab.bootstrap.DataHolder;

import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository {
    @Override
    public List<Book> findAll() {
        return DataHolder.books;
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return DataHolder.books.stream().
                filter(b -> b.getTitle().contains(text)
                        && b.getAverageRating() > rating).toList();
    }

}
