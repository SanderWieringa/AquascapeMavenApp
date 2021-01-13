package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.Aquascape;
import org.example.Plant;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class PlantController {

    public ObservableList<Plant> getPlants() {
        ObservableList<Plant> plants = FXCollections.observableArrayList();
        plants.add(new Plant(1, "Valisneria", 2));
        plants.add(new Plant(2, "Lotus", 4));

        return plants;
    }
}
