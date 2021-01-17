package org.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import restclient.controllers.AquascapeController;
import restshared.AquascapeDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeViewController /*implements Initializable*/ {

    /*AquascapeController aquascapeController = new AquascapeController();
    @FXML
    private TableView<AquascapeDTO> tableView;
    @FXML
    private TableColumn<AquascapeDTO, String> aquascapeNameColumn;
    @FXML
    private TableColumn<AquascapeDTO, String> aquascapeDifficultyColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aquascapeNameColumn.setCellValueFactory(new PropertyValueFactory<AquascapeDTO, String>("Aquascape Name"));
        aquascapeDifficultyColumn.setCellValueFactory(new PropertyValueFactory<AquascapeDTO, String>("Aquascape Difficulty"));

        tableView.setItems(getAquascapes());
    }

    public ObservableList<AquascapeDTO> getAquascapes() {
        return (ObservableList<AquascapeDTO>) aquascapeController.getAquascapes();
    }

    public void newAquascapeButtonClicked() {

    }*/
}
