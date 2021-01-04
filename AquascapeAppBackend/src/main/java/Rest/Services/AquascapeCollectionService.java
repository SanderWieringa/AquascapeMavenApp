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

    /*public ArrayList<Aquascape> getAllAquascapesByUser(String username)
    {
        return aquascapeCollectionRepository.findAllById(username);
    }*/

    public void addAquascape(Aquascape aquascape) {
        aquascapeCollectionRepository.save(aquascape);
    }
}
