package mk.ukim.finki.wp.lab1wp.service.impl;

import mk.ukim.finki.wp.lab1wp.model.Author;
import mk.ukim.finki.wp.lab1wp.model.Book;
import mk.ukim.finki.wp.lab1wp.repository.BookRepository;
import mk.ukim.finki.wp.lab1wp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBooks(String text, Double rating) {
        return bookRepository.searchBooks(text, rating);
    }

    @Override
    public Book save(String title, String genre, double rating, Author author) {
        Book book = new Book(title, genre, rating, author);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, String title, String genre, double rating, Author author) {
        Optional<Book> existingBook = bookRepository.findById(id);

        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(title);
            book.setGenre(genre);
            book.setAverageRating(rating);
            book.setAuthor(author);
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

}
