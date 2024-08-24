package relife.huranit.domain.tag.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import relife.huranit.domain.centertag.domain.CenterTag;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="tag_id" , updatable = false)
    private Long tagId;

    @Column(nullable = false , length = 50)
    private String tagName;

    @OneToMany(mappedBy = "tag" , cascade = CascadeType.ALL , orphanRemoval = true)
    List<CenterTag> centerTagList = new ArrayList<>();

    @Builder
    public Tag( String tagName){
        this.tagName = tagName;
    }
}
