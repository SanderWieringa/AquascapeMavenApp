package Rest.Repositories;

import Rest.Entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFishCollectionJpaRepository extends JpaRepository<Fish, Long> {
}
