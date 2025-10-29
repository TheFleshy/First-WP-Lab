package mk.ukim.finki.wp.lab1wp.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1wp.model.Book;
import mk.ukim.finki.wp.lab1wp.model.BookReservation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Book> books = null;
    public static List<BookReservation> reservations = null;

    @PostConstruct
    public void init() {
        books = new ArrayList<>();
        books.add(new Book("Inception", "Sci-Fi", 8.8));
        books.add(new Book("The Dark Knight", "Action", 9.0));
        books.add(new Book("Forrest Gump", "Drama", 8.8));
        books.add(new Book("The Godfather", "Crime", 9.2));
        books.add(new Book("Interstellar", "Sci-Fi", 8.6));
        books.add(new Book("The Shawshank Redemption", "Drama", 9.3));
        books.add(new Book("Gladiator", "Action", 8.5));
        books.add(new Book("The Matrix", "Sci-Fi", 8.7));
        books.add(new Book("Titanic", "Romance", 7.9));
        books.add(new Book("The Wolf of Wall Street", "Comedy", 8.2));
        reservations = new ArrayList<>();
    }
}
