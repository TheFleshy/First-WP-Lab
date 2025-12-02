package mk.ukim.finki.wp.lab1wp.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1wp.model.Author;
import mk.ukim.finki.wp.lab1wp.model.Book;
import mk.ukim.finki.wp.lab1wp.model.BookReservation;
import mk.ukim.finki.wp.lab1wp.repository.AuthorRepository;
import mk.ukim.finki.wp.lab1wp.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataHolder(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        if (authorRepository.count() > 0) {
            return;
        }

        List<Author> authors = new ArrayList<>();
        authors.add(new Author("George", "Orwell", "UK", "British novelist and essayist"));
        authors.add(new Author("J.K.", "Rowling", "UK", "British author, best known for Harry Potter"));
        authors.add(new Author("J.R.R.", "Tolkien", "UK", "English writer and professor"));
        authors.add(new Author("Agatha", "Christie", "UK", "British mystery writer"));
        authors.add(new Author("Mark", "Twain", "USA", "American writer and humorist"));

        authors = authorRepository.saveAll(authors);

        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "Dystopian Fiction", 4.7, authors.get(0)));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "Fantasy", 4.8, authors.get(1)));
        books.add(new Book("The Lord of the Rings", "Fantasy", 4.9, authors.get(2)));
        books.add(new Book("Murder on the Orient Express", "Mystery", 4.5, authors.get(3)));
        books.add(new Book("The Adventures of Tom Sawyer", "Adventure", 4.2, authors.get(4)));
        books.add(new Book("Animal Farm", "Political Satire", 4.6, authors.get(0)));
        books.add(new Book("Harry Potter and the Chamber of Secrets", "Fantasy", 4.7, authors.get(1)));
        books.add(new Book("The Hobbit", "Fantasy", 4.8, authors.get(2)));
        books.add(new Book("Death on the Nile", "Mystery", 4.4, authors.get(3)));
        books.add(new Book("Adventures of Huckleberry Finn", "Adventure", 4.3, authors.get(4)));

        bookRepository.saveAll(books);
    }
}
