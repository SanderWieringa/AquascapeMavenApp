package Rest.Services;

import Rest.Entities.Aquascape;
import Rest.Repositories.IAquascapeCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AquascapeCollectionService {
    @Autowired
    private IAquascapeCollectionRepository aquascapeCollectionRepository;

    private static AquascapeCollectionService instance;

    public static AquascapeCollectionService getInstance() {
        if (instance == null) {
            instance = new AquascapeCollectionService();
        }
        return instance;
    }

    public void addAquascape(Aquascape aquascape) {
        aquascapeCollectionRepository.save(aquascape);
    }

    public Aquascape getAquascapeById(int id) {
        return aquascapeCollectionRepository.findById(id);
    }

    public ArrayList<Aquascape> getAllAquascapes() {
        ArrayList<Aquascape> aquascapes = new ArrayList<>();
        aquascapeCollectionRepository.findAll().forEach(aquascapes::add);

        return aquascapes;
    }


}
