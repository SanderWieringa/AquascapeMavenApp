package Aquascape;

import Repository.IFishCollectionRepository;

import java.util.Optional;

public class FishCollection {
    private IFishCollectionRepository fishCollectionRepository;

    public FishCollection(IFishCollectionRepository fishCollectionRepository) {
        this.fishCollectionRepository = fishCollectionRepository;
    }
}
