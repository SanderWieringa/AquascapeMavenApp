package Repository;

import Aquascape.Fish;
import Aquascape.FishType;
import Aquascape.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IFishCollectionRepository extends CrudRepository<Fish, Long> {
}
