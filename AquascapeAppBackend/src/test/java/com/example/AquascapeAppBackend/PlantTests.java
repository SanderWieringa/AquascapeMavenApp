package com.example.AquascapeAppBackend;

import Rest.Entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlantTests {
    private AquascapeGenerator generator;
    private Aquascape aquascape;

    @BeforeEach
    void setUp() {
        aquascape = new Aquascape();
        generator = new AquascapeGenerator();
    }

    @Test
    void tryAddPlant_PlantPlusHerbivore_ShouldReturnFalse() {
        Plant plant = new Plant(1, "Valisneria", 2);
        Fish herbivore = new Fish(1, "Tetra", FishType.HERBIVORE, FishSize.SMALL);
        boolean tryAddPlant = generator.tryAddPlant(plant, aquascape);

        boolean tryAddHerbivore = generator.tryAddFish(herbivore, aquascape);

        assertTrue(tryAddPlant);
        assertFalse(tryAddHerbivore);
    }

    @Test
    void tryAddPlant_HerbivorePlusPlant_ShouldReturnFalse() {
        Fish herbivore = new Fish(1, "Tetra", FishType.HERBIVORE, FishSize.SMALL);
        Plant plant = new Plant(1, "Valisneria", 2);
        boolean tryAddHerbivore = generator.tryAddFish(herbivore, aquascape);

        boolean tryAddPlant = generator.tryAddPlant(plant, aquascape);

        assertTrue(tryAddHerbivore);
        assertFalse(tryAddPlant);
    }

    @Test
    void tryAddPlant_NormalPlusPlant_ShouldReturnTrue() {
        Fish normal = new Fish(1, "Tetra", FishType.OMNIVORE, FishSize.SMALL);
        Plant plant = new Plant(1, "Valisneria", 2);
        boolean tryAddNormal = generator.tryAddFish(normal, aquascape);

        boolean tryAddPlant = generator.tryAddPlant(plant, aquascape);

        assertTrue(tryAddNormal);
        assertTrue(tryAddPlant);
    }

    @Test
    void tryAddPlant_PlantPlusNormal_ShouldReturnTrue() {
        Plant plant = new Plant(1, "Valisneria", 2);
        Fish normal = new Fish(1, "Tetra", FishType.OMNIVORE, FishSize.SMALL);
        boolean tryAddPlant = generator.tryAddPlant(plant, aquascape);

        boolean tryAddNormal = generator.tryAddFish(normal, aquascape);

        assertTrue(tryAddPlant);
        assertTrue(tryAddNormal);
    }

    @Test
    void tryAddPlant_CarnivorePlusPlant_ShouldReturnTrue() {
        Fish carnivore = new Fish(1, "Angel Fish", FishType.CARNIVORE, FishSize.SMALL);
        Plant plant = new Plant(1, "Valisneria", 2);
        boolean tryAddCarnivore = generator.tryAddFish(carnivore, aquascape);

        boolean tryAddPlant = generator.tryAddPlant(plant, aquascape);

        assertTrue(tryAddCarnivore);
        assertTrue(tryAddPlant);
    }

    @Test
    void tryAddPlant_PlantPlusCarnivore_ShouldReturnTrue() {
        Plant plant = new Plant(1, "Valisneria", 2);
        Fish carnivore = new Fish(1, "Angel Fish", FishType.CARNIVORE, FishSize.SMALL);
        boolean tryAddPlant = generator.tryAddPlant(plant, aquascape);

        boolean tryAddCarnivore = generator.tryAddFish(carnivore, aquascape);

        assertTrue(tryAddPlant);
        assertTrue(tryAddCarnivore);
    }
}