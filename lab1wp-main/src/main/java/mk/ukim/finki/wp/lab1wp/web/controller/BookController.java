package mk.ukim.finki.wp.lab1wp.web.controller;

import mk.ukim.finki.wp.lab1wp.model.Author;
import mk.ukim.finki.wp.lab1wp.model.Book;
import mk.ukim.finki.wp.lab1wp.service.AuthorService;
import mk.ukim.finki.wp.lab1wp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String getBooksPage(
            @RequestParam(required = false) String error,
            @RequestParam(required = false) String search,
            Model model
    ) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Book> books;
        if (search != null && !search.isEmpty())
            books = bookService.searchBooks(search, 0.0);
        else
            books = bookService.listAll();

        model.addAttribute("books", books);
        return "listBooks";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        Author author = authorService.findById(authorId);
        bookService.save(title, genre, averageRating, author);
        return "redirect:/books";
    }

    @PostMapping("/edit/{bookId}")
    public String editBook(@PathVariable Long bookId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam Double averageRating,
                           @RequestParam Long authorId) {
        Author author = authorService.findById(authorId);
        bookService.update(bookId, title, genre, averageRating, author);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/book-form/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findById(id);

        if (book.isEmpty()) {
            return "redirect:/books?error=BookNotFound";
        }

        model.addAttribute("book", book.get());
        model.addAttribute("authors", authorService.findAll());
        return "book-form";
    }

    @GetMapping("/book-form")
    public String getAddBookPage(Model model){
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("book", null);
        return "book-form";
    }
}