package Rest.Repositories;

import Rest.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserCollectionRepository extends CrudRepository<User, String>
{
    @Override
    Optional<User> findById(String s);
}