package Repository;

import Aquascape.Plant;
import Aquascape.PlantCollection;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IPlantCollectionRepository extends CrudRepository<Plant, Long> {

}
