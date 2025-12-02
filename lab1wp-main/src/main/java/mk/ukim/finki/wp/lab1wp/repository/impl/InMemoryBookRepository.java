//package mk.ukim.finki.wp.lab1wp.repository.impl;
//
//import mk.ukim.finki.wp.lab1wp.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab1wp.model.Author;
//import mk.ukim.finki.wp.lab1wp.model.Book;
//import mk.ukim.finki.wp.lab1wp.repository.BookRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public class InMemoryBookRepository implements BookRepository {
//
//    @Override
//    public List<Book> findAll() {
//        return DataHolder.books;
//    }
//
//    @Override
//    public List<Book> searchBooks(String text, Double rating) {
//        return DataHolder.books.stream().filter(book -> (text == null ||
//                book.getTitle().toLowerCase().contains(text.toLowerCase())) &&
//                (rating == null || book.getAverageRating() >= rating)).collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<Book> findById(Long id) {
//        return DataHolder.books.stream()
//                .filter(b -> b.getId().equals(id))
//                .findFirst();
//    }
//
//    @Override
//    public Book save(String title, String genre, double rating, Author author) {
//        Book book = new Book(title, genre, rating, author);
//        DataHolder.books.add(book);
//        return book;
//    }
//
//    @Override
//    public Book update(Long id, String title, String genre, double rating, Author author) {
//        Optional<Book> existing = findById(id);
//        if (existing.isPresent()) {
//            Book b = existing.get();
//            b.setTitle(title);
//            b.setGenre(genre);
//            b.setAverageRating(rating);
//            b.setAuthor(author);
//            return b;
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//        DataHolder.books.removeIf(m -> m.getId().equals(id));
//    }
//
//}
