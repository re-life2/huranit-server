package relife.huranit.domain.centertag.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import relife.huranit.domain.center.domain.Center;
import relife.huranit.domain.tag.domain.Tag;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CenterTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="center_tag_id" , updatable = false)
    private Long centerTagId;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private Center center;

    @ManyToOne
    @JoinColumn(name ="tag_id")
    private Tag tag;

}
