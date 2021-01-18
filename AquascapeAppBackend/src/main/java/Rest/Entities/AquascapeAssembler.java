package Rest.Entities;

import java.util.List;

public class AquascapeAssembler {
    private Aquascape aquascape = new Aquascape();
    private AquascapeGenerator aquascapeGenerator = new AquascapeGenerator();

    public Aquascape AssemblePlants(List<Plant> selectedPlants, Aquascape aquascape) {
        for (Plant plant:selectedPlants) {
            if (!aquascapeGenerator.tryAddPlant(plant, aquascape)) {
                return new Aquascape(1, "Wrong aquascape", 1);
            }
        }

        return aquascape;
    }

    public Aquascape CreateAquascape() {
        return new Aquascape(0, "", 0);
    }
}
