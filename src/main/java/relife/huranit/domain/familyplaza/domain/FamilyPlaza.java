package relife.huranit.domain.familyplaza.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FamilyPlaza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="family_plaze_id" , updatable = false)
    private Long familyPlazaId;

    @Column
    private String imageUrl;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String applyMethod;

    @Column
    private String age;
}
