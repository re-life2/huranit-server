package relife.huranit.domain.center.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import relife.huranit.domain.center.domain.Center;
import relife.huranit.domain.center.dto.request.CenterRequestDto;
import relife.huranit.domain.center.dto.response.CenterDetailResponseDto;
import relife.huranit.domain.center.dto.response.CenterResponseDto;
import relife.huranit.domain.center.respository.CenterRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CenterService {

    private final CenterRepository centerRepository;

    /* 센터 상세 조회 */
    public CenterDetailResponseDto getCenterDetail(Long centerId) {
        Center center = centerRepository.findById(centerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 센터를 찾을 수 없습니다: " + centerId));
        return CenterDetailResponseDto.from(center);
    }

    /* 센터 이름 검색 & 태그 & 지역구 */
    public List<CenterResponseDto> findCenter(CenterRequestDto requestDto) {
        List<Center> centers = centerRepository.searchCenters(requestDto.search(), requestDto.tags() , requestDto.district());

        return centers.stream()
                .map(CenterResponseDto::from)
                .collect(Collectors.toList());
    }
}
