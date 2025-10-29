package mk.ukim.finki.wp.firstlab.service.impl;

import mk.ukim.finki.wp.firstlab.service.BookReservationService;
import org.springframework.stereotype.Service;
import mk.ukim.finki.wp.firstlab.repository.BookReservationRepository;
import mk.ukim.finki.wp.firstlab.model.BookReservation;

@Service
public class BookReservationServiceImpl implements BookReservationService {
    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, long numberOfCopies) {
        BookReservation bookReservation = new BookReservation(bookTitle, readerName, readerAddress, numberOfCopies);
        return bookReservationRepository.save(bookReservation);
    }
}
