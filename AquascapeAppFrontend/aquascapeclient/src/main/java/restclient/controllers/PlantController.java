package restclient.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import restshared.PlantDTO;

public class PlantController {

    public ObservableList<PlantDTO> getPlants() {
        ObservableList<PlantDTO> plants = FXCollections.observableArrayList();
        plants.add(new PlantDTO(1, "Valisneria", 2));
        plants.add(new PlantDTO(2, "Lotus", 4));

        return plants;
    }
}
