package org.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import restclient.controllers.AquascapeController;
import restshared.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AquascapeViewController implements Initializable {

    AquascapeDTO aquascape = new AquascapeDTO();
    @FXML
    private TextField aquascapeNameTextField;
    @FXML
    private TextField aquascapeDifficultyTextField;

    AquascapeController aquascapeController = new AquascapeController();
    @FXML
    private TableView<PlantDTO> plantTableView;
    @FXML
    private TableColumn<PlantDTO, String> plantNameColumn;
    @FXML
    private TableColumn<PlantDTO, Integer> plantDifficultyColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ItemViewController.setColumns(plantNameColumn, plantDifficultyColumn);
        //plantTableView.setItems(getPlantsInAquascape());
        //showAquascape();
    }

    public ObservableList<PlantDTO> getPlantsInAquascape() {
        return (ObservableList<PlantDTO>) aquascape.getPlantsInAquascape();
    }

    public void addPlantsButtonClicked(ActionEvent actionEvent) {

    }

    public void showAquascape(AquascapeResponse aquascapeSelected) {
        if (aquascapeSelected.isSuccess()) {
            aquascapeNameTextField.setText(aquascapeSelected.getAquascape().getName());
            aquascapeDifficultyTextField.setText(String.valueOf(aquascapeSelected.getAquascape().getDifficulty()));
            ObservableList<PlantDTO> list = FXCollections.observableList(aquascapeSelected.getAquascape().getPlantsInAquascape());
            plantTableView.setItems(list);
        }
    }
}
