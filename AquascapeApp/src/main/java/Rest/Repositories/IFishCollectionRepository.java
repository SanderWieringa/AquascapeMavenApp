package Rest.Repositories;

import Rest.Entities.Fish;
import org.springframework.data.repository.CrudRepository;

public interface IFishCollectionRepository extends CrudRepository<Fish, Long> {
}
