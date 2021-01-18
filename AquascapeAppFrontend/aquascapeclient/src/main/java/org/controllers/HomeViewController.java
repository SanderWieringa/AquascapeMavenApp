package org.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import restclient.controllers.AquascapeCollectionController;
import restclient.controllers.AquascapeController;
import restshared.AquascapeDTO;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomeViewController implements Initializable {

    AquascapeCollectionController aquascapeCollectionController = new AquascapeCollectionController();
    @FXML
    private TableView<AquascapeDTO> tableView;
    @FXML
    private TableColumn<AquascapeDTO, String> aquascapeNameColumn;
    @FXML
    private TableColumn<AquascapeDTO, String> aquascapeDifficultyColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aquascapeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        aquascapeDifficultyColumn.setCellValueFactory(new PropertyValueFactory<>("difficulty"));

        tableView.setItems(getAquascapes());
    }

    public ObservableList<AquascapeDTO> getAquascapes() {
        ObservableList<AquascapeDTO> list = FXCollections.observableList(aquascapeCollectionController.getAquascapes());
        return list;
    }

    public void editAquascapeEvent() {

    }

    public void newAquascapeButtonClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/ItemView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        tableView.getScene().getWindow().hide();
        stage.show();
    }
}
