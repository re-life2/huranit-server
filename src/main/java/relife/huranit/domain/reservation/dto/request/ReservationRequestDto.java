package relife.huranit.domain.reservation.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservationRequestDto(
        Long centerId,
        String seat,
        LocalDate reserveDay,
        LocalTime reserveStartTime,
        LocalTime reserveEndTime,
        String companyName, //기관명
        String departmentName,
        String name,
        String email,
        String companyCall, //사무실 연락처
        String userCall

) {

}
