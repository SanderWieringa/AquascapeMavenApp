package Repository;

import Aquascape.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlantCollectionJpaRepository extends JpaRepository<Plant, Long> {
}
