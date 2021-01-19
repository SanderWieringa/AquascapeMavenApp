package Rest.Repositories;

import Rest.Entities.Plant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlantCollectionRepository extends CrudRepository<Plant, Integer>
{
    Plant findById(int id);
}