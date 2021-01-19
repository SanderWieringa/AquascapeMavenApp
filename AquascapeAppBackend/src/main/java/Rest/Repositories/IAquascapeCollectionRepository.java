package Rest.Repositories;

import Rest.Entities.Aquascape;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAquascapeCollectionRepository extends CrudRepository<Aquascape, Integer>
{
    Aquascape findById(int id);
}