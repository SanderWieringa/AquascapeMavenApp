package AquascapeAppTests;

import Aquascape.Aquascape;
import Aquascape.Fish;
import Aquascape.FishType;
import Aquascape.Plant;
import Aquascape.AquascapeGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class FishTests {
    private AquascapeGenerator generator;
    private Aquascape aquascape;

    @BeforeEach
    void setUp() {
        aquascape = new Aquascape(new ArrayList<Plant>(), new ArrayList<Fish>(), 0, "", 0);
        generator = new AquascapeGenerator();
    }

    void tryAddFish_SmallHerbivorePlusMediumCarnivore_ShouldReturnFalse() {
        var smallherbivore = new Fish(1, "Tetra", FishType.HERBIVORE, 1);
        var mediumCarnivore = new Fish(2, "AngelFish", FishType.CARNIVORE, 3);

        var tryAddSmallHerbivore = generator.tryAddFish(smallherbivore, aquascape);
        var tryAddMediumCarnivore = generator.tryAddFish(mediumCarnivore, aquascape);
    }
}
