package example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restclient.controllers.AquascapeController;
import restshared.AquascapeDTO;

import java.io.IOException;

public class App extends Application {
    Scene scene1, scene2, scene3;
    Stage window;
    TableView<AquascapeDTO> table;
    TextField idInput, nameInput, difficultyInput;
    AquascapeController aquascapeController = new AquascapeController();

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("title");

        Menu fileMenu = new Menu("File");

        fileMenu.getItems().add(new MenuItem("New Project..."));
        fileMenu.getItems().add(new MenuItem("New Module..."));
        fileMenu.getItems().add(new MenuItem("Import Project..."));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        TableColumn<AquascapeDTO, Integer> idColumn = new TableColumn<AquascapeDTO, Integer>("Id");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(new PropertyValueFactory<>("AquascapeId"));

        TableColumn<AquascapeDTO, String> nameColumn = new TableColumn<AquascapeDTO, String>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn<AquascapeDTO, Integer> difficultyColumn = new TableColumn<AquascapeDTO, Integer>("Difficulty");
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
        table.setItems((ObservableList<AquascapeDTO>) aquascapeController.getAquascapes());
        table.getColumns().addAll(idColumn, nameColumn, difficultyColumn);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(idInput,nameInput,difficultyInput, addButton, deleteButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(menuBar, table, hBox);

        scene1 = new Scene(vBox);

        stage.setScene(scene1);
        stage.show();


        /*var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();*/
    }

    public void addButtonClicked() {
        AquascapeDTO aquascape = new AquascapeDTO();
        aquascape.setAquascapeId(Integer.parseInt(idInput.getText()));
        aquascape.setName(nameInput.getText());
        aquascape.setDifficulty(Integer.parseInt(difficultyInput.getText()));

        table.getItems().add(aquascape);
        idInput.clear();
        nameInput.clear();
        difficultyInput.clear();
    }

    public void deleteButtonClicked() {
        ObservableList<AquascapeDTO> aquascapeSelected, allAquascapes;
        allAquascapes = table.getItems();
        aquascapeSelected = table.getSelectionModel().getSelectedItems();

        aquascapeSelected.forEach(allAquascapes::remove);
    }

    public void getById() {
        AquascapeDTO aquascapeSelected = table.getSelectionModel().getSelectedItem();

    }

    //controller should get list of aquascapes


    public static void main(String[] args) {
        launch(args);
    }

}