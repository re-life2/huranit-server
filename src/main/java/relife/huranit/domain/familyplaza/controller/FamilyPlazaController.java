package relife.huranit.domain.familyplaza.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import relife.huranit.domain.familyplaza.dto.response.FamilyPlazaResponseDto;
import relife.huranit.domain.familyplaza.service.FamilyPlazaService;
import relife.huranit.global.common.SuccessResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/family-plaza")
@RestController
public class FamilyPlazaController {
    private final FamilyPlazaService familyPlazaService;

@GetMapping
    public ResponseEntity<?> getFamilyPlaza() {
    List<FamilyPlazaResponseDto> familyPlazaList = familyPlazaService.getFamilyPlaza();
    return SuccessResponse.ok(familyPlazaList);
    }
}
