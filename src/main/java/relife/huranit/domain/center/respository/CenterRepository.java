package relife.huranit.domain.center.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import relife.huranit.domain.center.domain.Center;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center , Long> , CustomCenterRepository{
}
