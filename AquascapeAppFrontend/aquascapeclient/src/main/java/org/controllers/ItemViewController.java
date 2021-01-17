package org.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import restclient.controllers.FishController;
import restclient.controllers.PlantController;
import restshared.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemViewController /*implements Initializable*/ {

    /*PlantController plantController = new PlantController();

    FishController fishController = new FishController();
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
        setColumns(plantNameColumn, plantDifficultyColumn*//*, fishNameColumn, fishTypeColumn, fishSizeColumn*//*);

        tableViewPlant.setItems(getPlants());
        *//*tableViewFish.setItems(getFishes());*//*
    }

    static void setColumns(TableColumn<PlantDTO, String> plantNameColumn, TableColumn<PlantDTO, Integer> plantDifficultyColumn*//*, TableColumn<FishDTO, String> fishNameColumn, TableColumn<FishDTO, FishType> fishTypeColumn, TableColumn<FishDTO, FishSize> fishSizeColumn*//*) {
        plantNameColumn.setCellValueFactory(new PropertyValueFactory<>("Plant Name"));
        plantDifficultyColumn.setCellValueFactory(new PropertyValueFactory<>("Plant Difficulty"));

        *//*fishNameColumn.setCellValueFactory(new PropertyValueFactory<>("Fish Name"));
        fishTypeColumn.setCellValueFactory(new PropertyValueFactory<>("Fish Type"));
        fishSizeColumn.setCellValueFactory(new PropertyValueFactory<>("Fish Size"));*//*
    }

    public ObservableList<PlantDTO> getPlants() {
        return plantController.getPlants();
    }

    public ObservableList<FishDTO> getFishes() {
        return fishController.getFishes();
    }*/
}
