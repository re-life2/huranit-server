package relife.huranit.domain.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import relife.huranit.domain.tag.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
