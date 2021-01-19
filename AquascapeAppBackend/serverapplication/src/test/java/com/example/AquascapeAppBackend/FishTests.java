package com.example.AquascapeAppBackend;

import Rest.Entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FishTests {
    private AquascapeGenerator generator;
    private Aquascape aquascape;

    @BeforeEach
    void setUp() {
        aquascape = new Aquascape();
        generator = new AquascapeGenerator();
    }

    @Test
    void tryAddFish_SmallHerbivorePlusMediumCarnivore_ShouldReturnFalse() {
        Fish smallHerbivore = new Fish(1, "Tetra", FishType.HERBIVORE, FishSize.SMALL);
        Fish mediumCarnivore = new Fish(2, "AngelFish", FishType.CARNIVORE, FishSize.MEDIUM);
        boolean tryAddSmallHerbivore = generator.tryAddFish(smallHerbivore, aquascape);

        boolean tryAddMediumCarnivore = generator.tryAddFish(mediumCarnivore, aquascape);

        assertTrue(tryAddSmallHerbivore);
        assertFalse(tryAddMediumCarnivore);
    }

    @Test
    void tryAddFish_MediumHerbivorePlusSmallCarnivore_ShouldReturnTrue() {
        Fish mediumHerbivore = new Fish(1, "Tetra", FishType.HERBIVORE, FishSize.MEDIUM);
        Fish smallCarnivore = new Fish(2, "AngelFish", FishType.CARNIVORE, FishSize.SMALL);
        boolean tryAddMediumHerbivore = generator.tryAddFish(mediumHerbivore, aquascape);

        boolean tryAddSmallCarnivore = generator.tryAddFish(smallCarnivore, aquascape);

        assertTrue(tryAddMediumHerbivore);
        assertTrue(tryAddSmallCarnivore);
    }

    @Test
    void TryAddFish_SmallCarnivorePlusMediumHerbivore_ShouldReturnTrue() {
        Fish smallCarnivore = new Fish(1, "AngelFish", FishType.CARNIVORE, FishSize.SMALL);
        Fish mediumHerbivore = new Fish(2, "Tetra", FishType.HERBIVORE, FishSize.MEDIUM);
        boolean tryAddSmallCarnivore = generator.tryAddFish(smallCarnivore, aquascape);

        boolean tryAddMediumHerbivore = generator.tryAddFish(mediumHerbivore, aquascape);

        assertTrue(tryAddSmallCarnivore);
        assertTrue(tryAddMediumHerbivore);
    }

    @Test
    void TryAddFish_MediumCarnivorePlusSmallHerbivore_ShouldReturnFalse() {
        Fish mediumCarnivore = new Fish(1, "AngelFish", FishType.CARNIVORE, FishSize.MEDIUM);
        Fish smallHerbivore = new Fish(2, "Tetra", FishType.HERBIVORE, FishSize.SMALL);
        boolean tryAddMediumCarnivore = generator.tryAddFish(mediumCarnivore, aquascape);

        boolean tryAddSmallHerbivore = generator.tryAddFish(smallHerbivore, aquascape);

        assertTrue(tryAddMediumCarnivore);
        assertFalse(tryAddSmallHerbivore);
    }

    @Test
    void TryAddFish_SmallHerbivorePlusMediumNormal_ShouldReturnTrue() {
        Fish smallHerbivore = new Fish(1, "Tetra", FishType.HERBIVORE, FishSize.SMALL);
        Fish mediumNormal = new Fish(2, "Tetra", FishType.OMNIVORE, FishSize.MEDIUM);
        boolean tryAddSmallHerbivore = generator.tryAddFish(smallHerbivore, aquascape);

        boolean tryAddMediumCarnivore = generator.tryAddFish(mediumNormal, aquascape);

        assertTrue(tryAddSmallHerbivore);
        assertTrue(tryAddMediumCarnivore);
    }

    @Test
    void TryAddFish_SmallNormalPlusMediumHerbivore_ShouldReturnTrue() {
        Fish smallNormal = new Fish(1, "Tetra", FishType.OMNIVORE, FishSize.SMALL);
        Fish mediumHerbivore = new Fish(2, "Tetra", FishType.HERBIVORE, FishSize.MEDIUM);
        boolean tryAddSmallNormal = generator.tryAddFish(smallNormal, aquascape);

        boolean tryAddMediumHerbivore = generator.tryAddFish(mediumHerbivore, aquascape);

        assertTrue(tryAddSmallNormal);
        assertTrue(tryAddMediumHerbivore);
    }

    @Test
    void TryAddFish_SmallCarnivorePlusMediumNormal_ShouldReturnTrue() {
        Fish smallCarnivore = new Fish(1, "AngelFish", FishType.CARNIVORE, FishSize.SMALL);
        Fish mediumNormal = new Fish(2, "Tetra", FishType.OMNIVORE, FishSize.MEDIUM);
        boolean tryAddSmallCarnivore = generator.tryAddFish(smallCarnivore, aquascape);

        boolean tryAddMediumNormal = generator.tryAddFish(mediumNormal, aquascape);

        assertTrue(tryAddSmallCarnivore);
        assertTrue(tryAddMediumNormal);
    }

    @Test
    void TryAddFish_MediumCarnivorePlusSmallNormal_ShouldReturnFalse() {
        Fish mediumCarnivore = new Fish(1, "AngelFish", FishType.CARNIVORE, FishSize.MEDIUM);
        Fish smallNormal = new Fish(2, "Tetra", FishType.OMNIVORE, FishSize.SMALL);
        boolean tryAddMediumCarnivore = generator.tryAddFish(mediumCarnivore, aquascape);

        boolean tryAddSmallNormal = generator.tryAddFish(smallNormal, aquascape);

        assertTrue(tryAddMediumCarnivore);
        assertFalse(tryAddSmallNormal);
    }

    @Test
    void TryAddFish_MediumNormalPlusSmallCarnivore_ShouldReturnTrue() {
        Fish mediumNormal = new Fish(1, "AngelFish", FishType.OMNIVORE, FishSize.MEDIUM);
        Fish smallCarnivore = new Fish(2, "Tetra", FishType.CARNIVORE, FishSize.SMALL);
        boolean tryAddMediumNormal = generator.tryAddFish(mediumNormal, aquascape);

        boolean tryAddSmallCarnivore = generator.tryAddFish(smallCarnivore, aquascape);

        assertTrue(tryAddMediumNormal);
        assertTrue(tryAddSmallCarnivore);
    }

    @Test
    void TryAddFish_SmallNormalPlusMediumCarnivore_ShouldReturnFalse() {
        Fish smallNormal = new Fish(1, "AngelFish", FishType.OMNIVORE, FishSize.SMALL);
        Fish mediumCarnivore = new Fish(2, "Tetra", FishType.CARNIVORE, FishSize.MEDIUM);
        boolean tryAddSmallNormal = generator.tryAddFish(smallNormal, aquascape);

        boolean tryAddMediumCarnivore = generator.tryAddFish(mediumCarnivore, aquascape);

        assertTrue(tryAddSmallNormal);
        assertTrue(tryAddMediumCarnivore);
    }
}
