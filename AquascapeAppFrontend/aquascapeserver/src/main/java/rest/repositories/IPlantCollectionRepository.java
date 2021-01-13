package rest.repositories;

import org.springframework.stereotype.Repository;
import rest.entities.Plant;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface IPlantCollectionRepository extends CrudRepository<Plant, Integer>
{
    Plant findById(int id);
}
