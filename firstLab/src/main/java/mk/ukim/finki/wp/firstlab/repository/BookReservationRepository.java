package mk.ukim.finki.wp.firstlab.repository;

import mk.ukim.finki.wp.firstlab.model.BookReservation;

public interface BookReservationRepository {
    BookReservation save(BookReservation reservation);
}
