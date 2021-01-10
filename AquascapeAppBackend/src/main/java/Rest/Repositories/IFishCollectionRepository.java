package Rest.Repositories;

import Rest.Entities.Fish;
import Rest.Entities.Plant;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface IFishCollectionRepository extends CrudRepository<Fish, Integer>
{
    Fish findById(int id);
}

