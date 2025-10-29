package mk.ukim.finki.wp.firstlab.service;

import java.util.List;
import mk.ukim.finki.wp.firstlab.model.Book;

public interface BookService {
    List<Book> listAll();
    List<Book> searchBooks(String text, Double rating);
}
