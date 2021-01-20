package org.controllers;

import endpoints.AquascapeEndPoint;
import endpoints.Communicator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import restclient.controllers.UserController;
import restshared.UserDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {

    private Communicator communicator = null;

    private AquascapeEndPoint endPoint;

    UserController userController = new UserController();
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        endPoint = AquascapeEndPoint.getInstance();
    }

    public void handleLoginClick(ActionEvent actionEvent) throws IOException {
        if (!(userNameTextField.getText() == null && passwordTextField.getText() == null)) {
            userController.login(new UserDTO(1, userNameTextField.getText(), passwordTextField.getText()));
            endPoint = AquascapeEndPoint.getInstance();
            endPoint.start();

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/HomeView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            userNameTextField.getScene().getWindow().hide();
            stage.show();
        }
    }

    public void handleregisterClick(ActionEvent actionEvent) {
        if (!(userNameTextField.getText() == null && passwordTextField.getText() == null)) {
            userController.register(new UserDTO(1, userNameTextField.getText(), passwordTextField.getText()));
        }
    }
}
