package relife.huranit.domain.center.dto.response;

import relife.huranit.domain.center.domain.Center;
import relife.huranit.domain.centertag.domain.CenterTag;

import java.util.List;
import java.util.stream.Collectors;

public record CenterResponseDto(
        Long centerId,
        String name,
        String addressDetail1,
        String addressDetail2,
        String addressDetail3,
        List<String> tags
) {
    public static CenterResponseDto from(Center center) {
        List<String> tags = center.getCenterTagList().stream()
                .map(centerTag -> centerTag.getTag().getTagName())
                .collect(Collectors.toList());

        return new CenterResponseDto(
                center.getCenterId(),
                center.getName(),
                center.getAddressDetail1(),
                center.getAddressDetail2(),
                center.getAddressDetail3(),
                tags
        );
    }
}
