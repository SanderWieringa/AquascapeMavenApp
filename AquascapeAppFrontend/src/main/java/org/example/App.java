package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    Stage window;
    TableView<Aquascape> table;
    TextField idInput, nameInput, difficultyInput;

    @Override
    public void start(Stage stage) {
        window = stage;
        window.setTitle("title");

        TableColumn<Aquascape, Integer> idColumn = new TableColumn<Aquascape, Integer>("Id");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("AquascapeId"));

        TableColumn<Aquascape, String> nameColumn = new TableColumn<Aquascape, String>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Aquascape, Integer> difficultyColumn = new TableColumn<Aquascape, Integer>("Difficulty");
        difficultyColumn.setMinWidth(100);
        difficultyColumn.setCellValueFactory(new PropertyValueFactory<>("Difficulty"));

        idInput = new TextField();
        idInput.setPromptText("Id");
        idInput.setMinWidth(100);

        nameInput = new TextField();
        nameInput.setPromptText("Name");

        difficultyInput = new TextField();
        difficultyInput.setPromptText("Difficulty");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        table = new TableView<>();
        table.setItems(getAquascapes());
        table.getColumns().addAll(idColumn, nameColumn, difficultyColumn);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(idInput,nameInput,difficultyInput, addButton, deleteButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();


        /*var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();*/
    }

    public void addButtonClicked() {
        Aquascape aquascape = new Aquascape();
        aquascape.setAquascapeId(Integer.parseInt(idInput.getText()));
        aquascape.setName(nameInput.getText());
        aquascape.setDifficulty(Integer.parseInt(difficultyInput.getText()));

        table.getItems().add(aquascape);
        idInput.clear();
        nameInput.clear();
        difficultyInput.clear();
    }

    public void deleteButtonClicked() {
        ObservableList<Aquascape> aquascapeSelected, allAquascapes;
        allAquascapes = table.getItems();
        aquascapeSelected = table.getSelectionModel().getSelectedItems();

        aquascapeSelected.forEach(allAquascapes::remove);
    }

    //controller should get list of aquascapes
    public ObservableList<Aquascape> getAquascapes() {
        ObservableList<Aquascape> aquascapes = FXCollections.observableArrayList();
        aquascapes.add(new Aquascape(1, "MyAquascape", 1));
        aquascapes.add(new Aquascape(2, "second aquascape", 3));

        return aquascapes;
    }

    public static void main(String[] args) {
        launch(args);
    }

}