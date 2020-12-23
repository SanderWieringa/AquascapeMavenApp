package Rest.Entities;

import Rest.Services.FishCollectionService;
import Rest.Services.PlantCollectionService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AquascapeGenerator
{
    @Autowired
    private PlantCollectionService plantCollectionService;

    @Autowired
    private FishCollectionService fishCollectionService;

    public AquascapeGenerator(PlantCollectionService plantCollectionService, FishCollectionService fishCollectionService)
    {
        this.plantCollectionService = plantCollectionService;
        this.fishCollectionService = fishCollectionService;
    }

    public AquascapeGenerator()
    {

    }

    public Aquascape generateAquascape()
    {
        Aquascape aquascape = new Aquascape(0, "", 0);
        Iterable<Plant> plantsIterable = plantCollectionService.getAllPlants();
        Iterable<Fish> fishesIterable = fishCollectionService.getAllFish();
        ArrayList<Plant> plants = Lists.newArrayList(plantsIterable);
        ArrayList<Fish> fishes = Lists.newArrayList(fishesIterable);

        for (int i = 0; i < plants.size(); i++)
        {
            Plant plant = plants.get(i);

            for (int y = 0; y < fishes.size(); y++)
            {
                Fish fish = fishes.get(y);

                if ((aquascape.getPlantsInAquarium().size() + 1) % 3 == 0 && aquascape.getPlantsInAquarium().size() != 0 && !aquascape.getFishInAquarium().contains(fish))
                {
                    tryAddFish(fish, aquascape);
                    break;
                }
            }
            tryAddPlant(plant, aquascape);
        }

        return new Aquascape();
    }

    public boolean tryAddPlant(Plant plant, Aquascape aquascape)
    {
        if (aquascape.getFishInAquarium().contains(FishType.HERBIVORE))
        {
            return false;
        }

        //synchronized add to list method used
        aquascape.addPlant(plant);
        return true;
    }

    ArrayList<Fish> carnivoresInAquascape = new ArrayList<>();

    public boolean tryAddFish(Fish fishToAdd, Aquascape aquascape)
    {
        if (fishToAdd.getFishType().equals(FishType.CARNIVORE))
        {
            if ((aquascape.getFishInAquarium().contains(FishType.HERBIVORE) || aquascape.getFishInAquarium().contains(FishType.OMNIVORE)) && containsFishSize(fishToAdd, aquascape))
            {
                return false;
            }
        }
        if (fishToAdd.getFishType().equals(FishType.HERBIVORE))
        {
            // if there exists a carnivore in the aquascape that is bigger than the herbivore to be added

            if(containsCarnivore(aquascape) && carnivoresInAquascape.stream().anyMatch(f -> f.getFishSize() > fishToAdd.getFishSize()))
            {
                return false;
            }
            if (aquascape.getPlantsInAquarium().size() != 0)
            {
                return false;
            }
        }
        if (fishToAdd.getFishType().equals(FishType.OMNIVORE))
        {
            // if there exists a carnivore in the aquascape that is bigger than the omnivore to be added
            if(containsCarnivore(aquascape) && carnivoresInAquascape.stream().anyMatch(f -> f.getFishSize() > fishToAdd.getFishSize()))
            {
                return false;
            }
        }
        //synchronized add to list method used
        aquascape.addFish(fishToAdd);
        return true;
    }

    private boolean containsCarnivore(Aquascape aquascape)
    {
        for (Fish fish:aquascape.getFishInAquarium())
        {
            if (fish.getFishType().equals(FishType.CARNIVORE))
            {
                carnivoresInAquascape.add(fish);
                return true;
            }
        }
        return false;
    }

    private boolean containsFishSize(Fish fishToAdd, Aquascape aquascape)
    {
        if (aquascape.getFishInAquarium().stream().filter(fish -> fish.getFishSize() < fishToAdd.getFishSize()).findFirst().isPresent())
        {
            return false;
        }

        return true;
    }
}
