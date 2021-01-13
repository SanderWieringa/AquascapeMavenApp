package rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.entities.Plant;
import rest.repositories.IPlantCollectionRepository;

import java.util.ArrayList;

@Service
public class PlantCollectionService {

    @Autowired
    private IPlantCollectionRepository plantCollectionRepository;

    public ArrayList<Plant> getAllPlants() {
        ArrayList<Plant> plants = new ArrayList<>();
        plantCollectionRepository.findAll().forEach(plants::add);

        return plants;
    }

    public void addPlant(Plant plant) {
        plantCollectionRepository.save(plant);
    }

    public Plant getPlantById(int id) {
        return plantCollectionRepository.findById(id);
    }
}
