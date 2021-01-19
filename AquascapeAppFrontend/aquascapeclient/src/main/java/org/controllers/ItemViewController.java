package org.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import restclient.controllers.PlantController;
import restshared.*;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemViewController implements Initializable {

    PlantController plantController = new PlantController();
    @FXML
    private TableView<PlantDTO> tableViewPlant;
    @FXML
    private TableColumn<PlantDTO, String> plantNameColumn;
    @FXML
    private TableColumn<PlantDTO, Integer> plantDifficultyColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColumns(plantNameColumn, plantDifficultyColumn);

        tableViewPlant.setItems(getPlants());
    }

    static void setColumns(TableColumn<PlantDTO, String> plantNameColumn, TableColumn<PlantDTO, Integer> plantDifficultyColumn) {
        plantNameColumn.setCellValueFactory(new PropertyValueFactory<>("plantName"));
        plantDifficultyColumn.setCellValueFactory(new PropertyValueFactory<>("difficulty"));

    }

    @FXML
    private void addSelectedItem(ActionEvent event) {

    }

    public void addPlantItem(TableColumn.CellEditEvent cellToAdd) {
        PlantDTO plantSelected = tableViewPlant.getSelectionModel().getSelectedItem();
    }

    public ObservableList<PlantDTO> getPlants() {
        ObservableList<PlantDTO> list = FXCollections.observableList(plantController.getPlants());
        return list;
    }
}
