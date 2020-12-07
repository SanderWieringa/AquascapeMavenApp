package Aquascape;

import Repository.IFishCollectionRepository;
import Repository.IPlantCollectionRepository;
import Services.FishCollectionService;
import Services.PlantCollectionService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AquascapeGenerator {
    @Autowired
    private PlantCollectionService plantCollectionService;

    @Autowired
    private FishCollectionService fishCollectionService;

    public AquascapeGenerator(PlantCollectionService plantCollectionService, FishCollectionService fishCollectionService) {
        this.plantCollectionService = plantCollectionService;
        this.fishCollectionService = fishCollectionService;
    }

    public AquascapeGenerator() {

    }

    public Aquascape generateAquascape() {
        Aquascape aquascape = new Aquascape(0, "", 0);
        Iterable<Plant> plantsIterable = plantCollectionService.getAllPlants();
        Iterable<Fish> fishesIterable = fishCollectionService.getAllFish();
        ArrayList<Plant> plants = Lists.newArrayList(plantsIterable);
        ArrayList<Fish> fishes = Lists.newArrayList(fishesIterable);

        for (int i = 0; i < plants.size(); i++) {
            Plant plant = plants.get(i);

            for (int y = 0; y < fishes.size(); y++) {
                Fish fish = fishes.get(y);

                if ((aquascape.getPlantsInAquarium().size() + 1) % 3 == 0 && aquascape.getPlantsInAquarium().size() != 0 && !aquascape.getFishInAquarium().contains(fish)) {
                    tryAddFish(fish, aquascape);
                    break;
                }
            }
            tryAddPlant(plant, aquascape);
        }

        return new Aquascape();
    }

    public boolean tryAddPlant(Plant plant, Aquascape aquascape) {
        if (aquascape.getFishInAquarium().contains(FishType.HERBIVORE)) {
            return false;
        }

        //synchronized add to list method used
        aquascape.addPlant(plant);
        return true;
    }

    public boolean tryAddFish(Fish fish, Aquascape aquascape) {
        if (fish.getFishType().equals(FishType.CARNIVORE)) {
            if ((aquascape.getFishInAquarium().contains(FishType.HERBIVORE) || aquascape.getFishInAquarium().contains(FishType.OMNIVORE)) && containsFishSize(fish, aquascape)) {
                return false;
            }
        }
        if (fish.getFishType().equals(FishType.HERBIVORE)) {
            // if there exists a carnivore in the aquascape that is bigger than the herbivore to be added
            /*if (aquascape.getFishInAquarium().contains(FishType.CARNIVORE) &&) {

            }*/
            if (aquascape.getPlantsInAquarium().size() != 0) {
                return false;
            }
        }
        if (fish.getFishType().equals(FishType.OMNIVORE)) {
            // if there exists a carnivore in the aquascape that is bigger than the omnivore to be added
            /*if (aquascape.getFishInAquarium()) {
                return false;
            }*/
        }

        aquascape.addFish(fish);
        return true;
    }

    private boolean containsFishSize(Fish fish, Aquascape aquascape) {
        if (aquascape.getFishInAquarium().stream().filter(f -> f.getFishSize() < fish.getFishSize()).findFirst().isPresent()) {
            return true;
        }

        return false;
    }
}
