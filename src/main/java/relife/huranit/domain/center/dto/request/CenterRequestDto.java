package relife.huranit.domain.center.dto.request;

import java.util.List;

public record CenterRequestDto(

        String search,
        List<String> tags,
        String district

){
}
