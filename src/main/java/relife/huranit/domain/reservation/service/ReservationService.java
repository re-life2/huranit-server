package relife.huranit.domain.reservation.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import relife.huranit.domain.center.domain.Center;
import relife.huranit.domain.center.respository.CenterRepository;
import relife.huranit.domain.reservation.domain.Reservation;
import relife.huranit.domain.reservation.dto.request.ReservationRequestDto;
import relife.huranit.domain.reservation.repository.ReservationRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final CenterRepository centerRepository;

    public void createReservation(ReservationRequestDto reservationRequest) {

        Center center = centerRepository.findById(reservationRequest.centerId())
                .orElseThrow(() -> new IllegalArgumentException("해당 센터를 찾을 수 없습니다: " + reservationRequest.centerId()));

        Reservation reservation = Reservation.builder()
                .center(center)
                .seat(reservationRequest.seat())
                .reserveDay(reservationRequest.reserveDay())
                .reserveStartTime(reservationRequest.reserveStartTime())
                .reserveEndTime(reservationRequest.reserveEndTime())
                .companyName(reservationRequest.companyName())
                .departmentName(reservationRequest.departmentName())
                .name(reservationRequest.name())
                .email(reservationRequest.email())
                .companyCall(reservationRequest.companyCall())
                .userCall(reservationRequest.userCall())
                .build();

        reservationRepository.save(reservation);
    }
}
