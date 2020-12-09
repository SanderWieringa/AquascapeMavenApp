package Rest.Entities;

import Rest.Repositories.IPlantCollectionRepository;

public class PlantCollection {
    private IPlantCollectionRepository plantCollectionRepository;

    public PlantCollection(IPlantCollectionRepository plantCollectionRepository) {
        this.plantCollectionRepository = plantCollectionRepository;
    }
}
