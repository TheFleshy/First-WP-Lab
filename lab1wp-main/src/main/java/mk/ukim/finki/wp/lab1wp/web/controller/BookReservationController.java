package mk.ukim.finki.wp.lab1wp.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab1wp.model.Book;
import mk.ukim.finki.wp.lab1wp.model.BookReservation;
import mk.ukim.finki.wp.lab1wp.service.BookReservationService;
import mk.ukim.finki.wp.lab1wp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
@RequestMapping("/bookReservation")
public class BookReservationController {
    private final BookService bookService;
    private final BookReservationService bookReservationService;

    public BookReservationController(BookService bookService, BookReservationService bookReservationService) {
        this.bookService = bookService;
        this.bookReservationService = bookReservationService;
    }

    @PostMapping
    public String makeReservation(
            @RequestParam Long bookId,
            @RequestParam String readerName,
            @RequestParam String readerAddress,
            @RequestParam Integer numCopies,
            HttpServletRequest request,
            Model model) {

        Optional<Book> bookOptional = bookService.findById(bookId);

        if (bookOptional.isEmpty()) {
            return "redirect:/books?error=BookNotFound";
        }

        Book book = bookOptional.get();
        String ipAddress = request.getRemoteAddr();

        BookReservation reservation = bookReservationService
                .placeReservation(book.getTitle(), readerName, readerAddress, numCopies);

        model.addAttribute("reservation", reservation);
        model.addAttribute("ipAddress", ipAddress);

        return "reservationConfirmation";
    }
}