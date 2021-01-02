package Rest.Repositories;

import Rest.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface IUserCollectionRepository extends CrudRepository<User, String>
{
    @Override
    Optional<User> findById(String s);
}
