package Rest.Repositories;

import Rest.Entities.Aquascape;
import Rest.Entities.Fish;
import Rest.Entities.Plant;
import Rest.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface IAquascapeCollectionRepository extends CrudRepository<Aquascape, String>
{
    //ArrayList<Aquascape> findAllById(String username);
}