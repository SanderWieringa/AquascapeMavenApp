package Rest.Services;

import Rest.Entities.Aquascape;
import Rest.Repositories.IAquascapeCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AquascapeCollectionService
{
    @Autowired
    private IAquascapeCollectionRepository aquascapeCollectionRepository;

    /*public ArrayList<Aquascape> getAllAquascapesByUser(int userId)
    {
        return aquascapeCollectionRepository.findAllById(userId);
    }*/

    public void addAquascape(Aquascape aquascape) {
        aquascapeCollectionRepository.save(aquascape);
    }

    public Aquascape getAquascapeById(int id) {
        return aquascapeCollectionRepository.findById(id);
    }
}
