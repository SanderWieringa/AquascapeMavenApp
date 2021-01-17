package restclient.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import restshared.FishDTO;
import restshared.FishSize;
import restshared.FishType;

public class FishController {
    public ObservableList<FishDTO> getFishes() {
        ObservableList<FishDTO> fishes = FXCollections.observableArrayList();
        fishes.add(new FishDTO(1, "Tetra", FishType.OMNIVORE, FishSize.MEDIUM));
        fishes.add(new FishDTO(2, "Angelfish", FishType.CARNIVORE, FishSize.LARGE));

        return fishes;
    }
}
