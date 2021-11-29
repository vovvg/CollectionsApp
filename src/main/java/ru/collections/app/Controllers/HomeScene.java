package ru.collections.app.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import ru.collections.app.Entity.Collection;
import ru.collections.app.JavaFxApp;
import ru.collections.app.Service.CollectionService;
import ru.collections.app.Service.CollectionServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

@FxmlView("/fxml/HomeScene.fxml")
public class HomeScene {



    CollectionService collectionService = new CollectionServiceImpl();

    @FXML
    private Label user;
    @FXML
    public ListView collectionList;
    @FXML
    public Button back;

    public void setUser(String getUser) {
        user.setText(getUser);
    }

    public void setListCards() throws ExecutionException, InterruptedException {
        ArrayList<Collection> collection = collectionService.getAllCollections(user.getText());
        for (Collection c : collection) {
            Button button = new Button(c.getCollectionName());
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    FXMLLoader loader = new FXMLLoader(JavaFxApp.class.getResource("/fxml/CollectionScene.fxml"));
                    Parent root = null;
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    CollectionScene collectionScene = loader.getController();
                    collectionScene.setCollectionName(c.getCollectionName());
                    collectionScene.setUser(user.getText());
                    collectionScene.setCollection();
                    try {
                        collectionScene.viewCollection();
                    } catch (ExecutionException | InterruptedException e) {
                        e.printStackTrace();
                    }

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
            });
            collectionList.getItems().add(button);
        }
    }

    public void initialize() throws ExecutionException, InterruptedException {


//        columnCards.setCellValueFactory(new PropertyValueFactory<>("cards"));
//        ObservableList<Integer> list = FXCollections.observableArrayList();
//            for (int i = 1; i < cards.getNumeric().size(); i++)
//                list.add(cards.getNumeric().get(i));
//
//        columnCards.setCellValueFactory(
//                (Callback<TableColumn.CellDataFeatures<Collection, ArrayList<Integer>>, ObservableValue<String>>) p -> new ReadOnlyStringWrapper(
//                        p.getValue().getNumeric().toString()));
//
//        table.setItems(list);

    }

    public void createCollection(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(JavaFxApp.class.getResource("/fxml/CreateCollectionScene.fxml"));
        Parent root = loader.load();
        CreateCollectionScene collectionScene = loader.getController();
        collectionScene.setUser((user.getText()));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void backScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(JavaFxApp.class.getResource("/fxml/LoginScene.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
