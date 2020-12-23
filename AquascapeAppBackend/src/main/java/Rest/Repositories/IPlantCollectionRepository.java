package Rest.Repositories;

import Rest.Entities.Plant;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface IPlantCollectionRepository extends CrudRepository<Plant, Integer> {

}