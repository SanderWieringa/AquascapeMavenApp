package rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entities.Fish;
import rest.repositories.IFishCollectionRepository;

import java.util.ArrayList;

@Service
public class FishCollectionService {

    @Autowired
    private IFishCollectionRepository fishCollectionRepository;

    public ArrayList<Fish> getAllFishes() {
        ArrayList<Fish> fishes = new ArrayList<>();
        fishCollectionRepository.findAll().forEach(fishes::add);

        return fishes;
    }

    public void addFish(Fish fish) {
        fishCollectionRepository.save(fish);
    }

    public Fish getFishById(int id) {
        return fishCollectionRepository.findById(id);
    }
}
