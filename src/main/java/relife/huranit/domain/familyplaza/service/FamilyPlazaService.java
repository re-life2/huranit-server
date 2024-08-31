package relife.huranit.domain.familyplaza.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import relife.huranit.domain.familyplaza.dto.response.FamilyPlazaResponseDto;
import relife.huranit.domain.familyplaza.repository.FamilyPlazaRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class FamilyPlazaService {
    private final FamilyPlazaRepository familyPlazaRepository;
    public List<FamilyPlazaResponseDto> getFamilyPlaza(){
        return familyPlazaRepository.findAll().stream()
                .map(FamilyPlazaResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
