package relife.huranit.domain.center.dto.response;

import relife.huranit.domain.center.domain.Center;

import java.time.LocalTime;

public record CenterDetailResponseDto(
        Long centerId,
        String name,
        String imageUrl,
        String phoneNumber,
        String addressDetail1,
        String addressDetail2,
        String addressDetail3,
        LocalTime startTime,
        LocalTime endTime,
        LocalTime lunchStartTime,
        LocalTime lunchEndTime
) {
    public static CenterDetailResponseDto from(Center center){
        return new CenterDetailResponseDto(
                center.getCenterId(),
                center.getName(),
                center.getImageUrl(),
                center.getPhoneNumber(),
                center.getAddressDetail1(),
                center.getAddressDetail2(),
                center.getAddressDetail3(),
                center.getStartTime(),
                center.getEndTime(),
                center.getLunchStartTime(),
                center.getLunchEndTime()
        );
    }
}
