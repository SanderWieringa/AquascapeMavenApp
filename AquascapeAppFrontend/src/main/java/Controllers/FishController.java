package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Fish;
import org.example.FishSize;
import org.example.FishType;
import org.example.Plant;

public class FishController {
    public ObservableList<Fish> getFishes() {
        ObservableList<Fish> fishes = FXCollections.observableArrayList();
        fishes.add(new Fish(1, "Tetra", FishType.OMNIVORE, FishSize.MEDIUM));
        fishes.add(new Fish(2, "Angelfish", FishType.CARNIVORE, FishSize.LARGE));

        return fishes;
    }
}
