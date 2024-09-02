package relife.huranit.domain.center.respository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import relife.huranit.domain.center.domain.Center;
import relife.huranit.domain.center.domain.QCenter;
import relife.huranit.domain.centertag.domain.QCenterTag;
import relife.huranit.domain.tag.domain.QTag;

import java.util.List;

@Repository
@AllArgsConstructor
public class CustomCenterRepositoryImpl implements CustomCenterRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Center> searchCenters(String name, List<String> tags, String district) {
        QCenter center = QCenter.center;
        QCenterTag centerTag = QCenterTag.centerTag;
        QTag tag = QTag.tag;

        return jpaQueryFactory
                .selectFrom(center)
                .leftJoin(center.centerTagList, centerTag)
                .leftJoin(centerTag.tag, tag)
                .where(
                        name != null ? center.name.containsIgnoreCase(name) : null,
                        district != null ? center.addressDetail1.containsIgnoreCase(district) : null,
                        tags != null && !tags.isEmpty() ? tag.tagName.in(tags) : null
                )
                .fetch();
    }
}
