package mk.ukim.finki.wp.lab1wp.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1wp.model.Author;
import mk.ukim.finki.wp.lab1wp.model.Book;
import mk.ukim.finki.wp.lab1wp.model.BookReservation;
import mk.ukim.finki.wp.lab1wp.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;
    public static List<BookReservation> reservations = null;

    private final AuthorRepository authorRepository;

    public DataHolder(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @PostConstruct
    public void init() {

        List<Author> authors = authorRepository.findAll();

        books = new ArrayList<>();
        books.add(new Book("Inception", "Sci-Fi", 8.8, authors.get(0)));
        books.add(new Book("The Dark Knight", "Action", 9.0, authors.get(1)));
        books.add(new Book("Forrest Gump", "Drama", 8.8, authors.get(2)));
        books.add(new Book("The Godfather", "Crime", 9.2, authors.get(0)));
        books.add(new Book("Interstellar", "Sci-Fi", 8.6, authors.get(1)));
        books.add(new Book("The Shawshank Redemption", "Drama", 9.3, authors.get(2)));
        books.add(new Book("Gladiator", "Action", 8.5, authors.get(0)));
        books.add(new Book("The Matrix", "Sci-Fi", 8.7, authors.get(1)));
        books.add(new Book("Titanic", "Romance", 7.9, authors.get(2)));
        books.add(new Book("The Wolf of Wall Street", "Comedy", 8.2, authors.get(1)));
        reservations = new ArrayList<>();
    }
}
