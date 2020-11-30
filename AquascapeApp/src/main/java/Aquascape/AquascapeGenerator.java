package Aquascape;

public class AquascapeGenerator {
    private PlantCollection plantCollection;
    private FishCollection fishCollection;

    public AquascapeGenerator(PlantCollection plantCollection, FishCollection fishCollection) {
        this.plantCollection = plantCollection;
        this.fishCollection = fishCollection;
    }

    public Aquascape generateAquascape() {
        return new Aquascape();
    }

    public boolean tryAddPlant(Plant plant) {
        return true;
    }
}
