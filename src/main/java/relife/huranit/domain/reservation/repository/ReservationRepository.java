package relife.huranit.domain.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import relife.huranit.domain.reservation.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation , Long> {
}
