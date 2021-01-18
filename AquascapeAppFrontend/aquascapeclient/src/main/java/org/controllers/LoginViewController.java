package org.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import restclient.controllers.UserController;
import restshared.UserDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginViewController implements Initializable {

    UserController userController = new UserController();
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleLoginClick(ActionEvent actionEvent) {
        if (!(userNameTextField.getText() == null && passwordTextField.getText() == null)) {
            userController.login(new UserDTO(userNameTextField.getText(), passwordTextField.getText()));
        }

    }


    public void handleregisterClick(ActionEvent actionEvent) {
        if (!(userNameTextField.getText() == null && passwordTextField.getText() == null)) {
            userController.register(new UserDTO(userNameTextField.getText(), passwordTextField.getText()));
        }
    }
}
