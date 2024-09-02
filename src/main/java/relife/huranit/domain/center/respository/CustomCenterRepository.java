package relife.huranit.domain.center.respository;

import relife.huranit.domain.center.domain.Center;

import java.util.List;


public interface CustomCenterRepository {
    List<Center> searchCenters(String name, List<String> tags, String district);
}
