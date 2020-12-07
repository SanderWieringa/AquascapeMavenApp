package Services;

import Aquascape.Plant;
import Repository.IPlantCollectionJpaRepository;
import Repository.IPlantCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlantCollectionService {
    @Autowired
    private IPlantCollectionJpaRepository plantCollectionJpaRepository;

    @Autowired
    private IPlantCollectionRepository plantCollectionRepository;

    public ArrayList<Plant> getAllPlants() {
        ArrayList<Plant> plants = new ArrayList<>();
        plantCollectionRepository.findAll().forEach(plants::add);

        return plants;
    }
}
