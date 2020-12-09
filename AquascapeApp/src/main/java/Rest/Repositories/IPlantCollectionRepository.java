package Rest.Repositories;

import Rest.Entities.Plant;
import org.springframework.data.repository.CrudRepository;

public interface IPlantCollectionRepository extends CrudRepository<Plant, Long> {

}
