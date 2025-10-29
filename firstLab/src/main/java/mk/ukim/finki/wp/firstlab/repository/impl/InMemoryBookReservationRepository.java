package mk.ukim.finki.wp.firstlab.repository.impl;

import mk.ukim.finki.wp.firstlab.repository.BookReservationRepository;
import org.springframework.stereotype.Repository;
import mk.ukim.finki.wp.firstlab.model.BookReservation;
import mk.ukim.finki.wp.firstlab.bootstrap.DataHolder;

@Repository
public class InMemoryBookReservationRepository implements BookReservationRepository {

    @Override
    public BookReservation save(BookReservation reservation) {
        DataHolder.reservations.removeIf(b -> b.getBookTitle().equals(reservation.getBookTitle()));

        DataHolder.reservations.add(reservation);
        return reservation;
    }
}
