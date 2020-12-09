package Rest.Entities;

import Rest.Repositories.IFishCollectionRepository;

public class FishCollection {
    private IFishCollectionRepository fishCollectionRepository;

    public FishCollection(IFishCollectionRepository fishCollectionRepository) {
        this.fishCollectionRepository = fishCollectionRepository;
    }
}
