package org.controllers;

import communicatorshared.CommunicatorWebSocketMessage;
import communicatorshared.CommunicatorWebSocketMessageOperation;
import endpoints.AquascapeEndPoint;
import endpoints.Communicator;
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
import listeners.CreateAquascapeChangeListener;
import restclient.controllers.AquascapeCollectionController;
import restshared.AquascapeDTO;
import restshared.AquascapeResponse;
import restshared.PlantDTO;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeViewController implements Initializable, PropertyChangeListener {

    private AquascapeEndPoint endPoint;

    AquascapeViewController aquascapeViewController = new AquascapeViewController();

    AquascapeCollectionController aquascapeCollectionController = new AquascapeCollectionController();
    @FXML
    private TableView<AquascapeDTO> tableView;
    @FXML
    private TableColumn<AquascapeDTO, String> aquascapeNameColumn;
    @FXML
    private TableColumn<AquascapeDTO, String> aquascapeDifficultyColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        endPoint = AquascapeEndPoint.getInstance();
        aquascapeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        aquascapeDifficultyColumn.setCellValueFactory(new PropertyValueFactory<>("difficulty"));

        tableView.setItems(getAquascapes());
    }

    public ObservableList<AquascapeDTO> getAquascapes() {
        ObservableList<AquascapeDTO> list = FXCollections.observableList(aquascapeCollectionController.getAquascapes());
        return list;
    }

    public void editAquascapeEvent (TableColumn.CellEditEvent event) {
        AquascapeDTO aquascapeSelected = tableView.getSelectionModel().getSelectedItem();
        AquascapeResponse aquascapeResponse = new AquascapeResponse();
        aquascapeResponse.setAquascape(aquascapeSelected);
        aquascapeViewController.showAquascape(aquascapeResponse);
    }

    public void newAquascapeButtonClicked(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AquascapeView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        tableView.getScene().getWindow().hide();
        CommunicatorWebSocketMessage communicatorWebSocketMessage = new CommunicatorWebSocketMessage();
        communicatorWebSocketMessage.setOperation(CommunicatorWebSocketMessageOperation.CREATE_AQUASCAPE);
        endPoint.addListener("CREATEAQUASCAPE", new CreateAquascapeChangeListener(aquascapeViewController, endPoint));
        endPoint.sendRequestToServer(communicatorWebSocketMessage);
        stage.show();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
