package wcf.javawebdeveloper.javawebdeveloperProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wcf.javawebdeveloper.javawebdeveloperProject.model.Feature;

import java.util.List;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {


}
