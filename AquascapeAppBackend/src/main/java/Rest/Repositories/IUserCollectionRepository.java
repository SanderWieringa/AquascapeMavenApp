package Rest.Repositories;

import Rest.Entities.User;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface IUserCollectionRepository extends CrudRepository<User, Integer> {
}
