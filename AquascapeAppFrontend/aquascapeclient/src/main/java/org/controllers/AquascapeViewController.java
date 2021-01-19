package org.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import restclient.controllers.AquascapeController;
import restshared.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AquascapeViewController implements Initializable {

    AquascapeController aquascapeController = new AquascapeController();
    @FXML
    private TableView<PlantDTO> tableViewPlant;
    @FXML
    private TableColumn<PlantDTO, String> plantNameColumn;
    @FXML
    private TableColumn<PlantDTO, Integer> plantDifficultyColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ItemViewController.setColumns(plantNameColumn, plantDifficultyColumn);
    }

    public ObservableList<PlantDTO> getPlantsByAquascape(String id) {
        return (ObservableList<PlantDTO>) aquascapeController.getPlantsByAquascape(id);
    }

    public void addPlant() {

    }
}
