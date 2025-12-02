package mk.ukim.finki.wp.lab1wp.repository;

import mk.ukim.finki.wp.lab1wp.model.BookReservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookReservationRepository extends JpaRepository<BookReservation, Long> {
    BookReservation save(BookReservation reservation);
}
