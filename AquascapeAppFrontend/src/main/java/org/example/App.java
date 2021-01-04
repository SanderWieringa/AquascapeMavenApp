package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    Stage window;
    TableView<Aquascape> table;

    @Override
    public void start(Stage stage) {
        window = stage;
        window.setTitle("title");

        TableColumn<Aquascape, Integer> idColumn = new TableColumn<Aquascape, Integer>("Id");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("AquascapeId"));

        TableColumn<Aquascape, String> nameColumn = new TableColumn<Aquascape, String>("Name");
        idColumn.setMinWidth(200);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<Aquascape, Integer> difficultyColumn = new TableColumn<Aquascape, Integer>("Difficulty");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("Difficulty"));

        table = new TableView<>();
        table.setItems(getAquascapes());
        table.getColumns().addAll(idColumn, nameColumn, difficultyColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table);

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