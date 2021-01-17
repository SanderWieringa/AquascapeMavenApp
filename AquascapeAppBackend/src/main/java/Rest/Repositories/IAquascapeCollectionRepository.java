package Rest.Repositories;

import Rest.Entities.Aquascape;
import Rest.Entities.Plant;
import Rest.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IAquascapeCollectionRepository extends CrudRepository<Aquascape, Integer>
{
    Aquascape findById(int id);
    //ArrayList<Aquascape> findAllById(int userId);
}