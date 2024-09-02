package relife.huranit.domain.familyplaza.dto.response;

import relife.huranit.domain.familyplaza.domain.FamilyPlaza;

public record FamilyPlazaResponseDto(

        Long familyPlazaId,
        String name,
        String imageUrl,
        String description,
        String age,
        String applyMethod,
        String link
) {
    public static FamilyPlazaResponseDto fromEntity(FamilyPlaza familyPlaza) {
        return new FamilyPlazaResponseDto(
                familyPlaza.getFamilyPlazaId(),
                familyPlaza.getName(),
                familyPlaza.getImageUrl(),
                familyPlaza.getDescription(),
                familyPlaza.getAge(),
                familyPlaza.getApplyMethod(),
                familyPlaza.getLink()
        );
    }
}
