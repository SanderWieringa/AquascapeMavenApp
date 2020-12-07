package Aquascape;

import Repository.IPlantCollectionRepository;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class PlantCollection {
    private IPlantCollectionRepository plantCollectionRepository;

    public PlantCollection(IPlantCollectionRepository plantCollectionRepository) {
        this.plantCollectionRepository = plantCollectionRepository;
    }
}
