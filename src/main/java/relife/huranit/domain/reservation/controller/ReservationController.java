package relife.huranit.domain.reservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import relife.huranit.domain.reservation.dto.request.ReservationRequestDto;
import relife.huranit.domain.reservation.service.ReservationService;

@RequiredArgsConstructor
@RequestMapping("/api/reservation")
@RestController
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody ReservationRequestDto reservationRequest) {
        reservationService.createReservation(reservationRequest);
        return ResponseEntity.ok().build();
    }
}
