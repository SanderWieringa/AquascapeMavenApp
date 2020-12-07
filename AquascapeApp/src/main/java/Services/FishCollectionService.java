package Services;

import Aquascape.Fish;
import Repository.IFishCollectionJpaRepository;
import Repository.IFishCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FishCollectionService {
    @Autowired
    private IFishCollectionJpaRepository fishCollectionJpaRepository;

    @Autowired
    private IFishCollectionRepository fishCollectionRepository;

    public ArrayList<Fish> getAllFish() {
        ArrayList<Fish> fishes = new ArrayList<>();
        fishCollectionRepository.findAll().forEach(fishes::add);

        return fishes;
    }
}
