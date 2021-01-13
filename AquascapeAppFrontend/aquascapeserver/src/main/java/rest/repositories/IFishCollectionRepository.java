package rest.repositories;

import org.springframework.stereotype.Repository;
import rest.entities.Fish;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface IFishCollectionRepository extends CrudRepository<Fish, Integer>
{
    Fish findById(int id);
}