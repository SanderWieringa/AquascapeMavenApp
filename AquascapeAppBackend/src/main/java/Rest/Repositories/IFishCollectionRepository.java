package Rest.Repositories;

import Rest.Entities.Fish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFishCollectionRepository extends CrudRepository<Fish, Integer>
{
    Fish findById(int id);
}

