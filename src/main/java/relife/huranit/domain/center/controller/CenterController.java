package relife.huranit.domain.center.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import relife.huranit.domain.center.dto.request.CenterRequestDto;
import relife.huranit.domain.center.dto.response.CenterDetailResponseDto;
import relife.huranit.domain.center.dto.response.CenterResponseDto;
import relife.huranit.domain.center.service.CenterService;
import relife.huranit.global.common.SuccessResponse;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/smart-work-center")
@RestController
public class CenterController {

    private final CenterService centerService;

    /*스마트 워크 센터 상세 조회*/
    @GetMapping("/{centerId}")
    public ResponseEntity<?> getCenterDetail(@PathVariable("centerId") Long centerId){
        CenterDetailResponseDto centerDetailResponseDto = centerService.getCenterDetail(centerId);
        return SuccessResponse.ok(centerDetailResponseDto);
    }

    /*스마트 워크 센터 검색 (검색어 & 태그 & 지역구)*/
    @GetMapping
    public ResponseEntity<?> getCenter(@RequestBody CenterRequestDto requestDto){
         List<CenterResponseDto> centerResponse = centerService.findCenter(requestDto);
         return SuccessResponse.ok(centerResponse);
    }
}
