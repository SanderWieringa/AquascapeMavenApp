package Rest.Repositories;

import Rest.Entities.Fish;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface IFishCollectionRepository extends CrudRepository<Fish, Integer>
{
}

