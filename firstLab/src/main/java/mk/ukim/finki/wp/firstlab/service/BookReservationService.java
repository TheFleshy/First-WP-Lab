package mk.ukim.finki.wp.firstlab.service;

import mk.ukim.finki.wp.firstlab.model.BookReservation;

public interface BookReservationService {
    BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, long numberOfCopies);
}
