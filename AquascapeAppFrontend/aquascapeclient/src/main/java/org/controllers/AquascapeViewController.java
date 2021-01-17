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

public class AquascapeViewController /*implements Initializable*/ {

   /* AquascapeController aquascapeController = new AquascapeController();
    @FXML
    private TableView<PlantDTO> tableViewPlant;
    @FXML
    private TableColumn<PlantDTO, String> plantNameColumn;
    @FXML
    private TableColumn<PlantDTO, Integer> plantDifficultyColumn;
    *//*@FXML
    private TableView<FishDTO> tableViewFish;
    @FXML
    private TableColumn<FishDTO, String> fishNameColumn;
    @FXML
    private TableColumn<FishDTO, FishType> fishTypeColumn;
    @FXML
    private TableColumn<FishDTO, FishSize> fishSizeColumn;*//*

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ItemViewController.setColumns(plantNameColumn, plantDifficultyColumn*//*, fishNameColumn, fishTypeColumn, fishSizeColumn*//*);
    }

    public ObservableList<PlantDTO> getPlantsByAquascape(String id) {
        return (ObservableList<PlantDTO>) aquascapeController.getPlantsByAquascape(id);
    }*/

    /*public ObservableList<FishDTO> getFishesByAquascape() {
        return aquascapeController.getFishesByAquascape();
    }*/
}
