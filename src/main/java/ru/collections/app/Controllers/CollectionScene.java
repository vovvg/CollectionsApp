package ru.collections.app.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import ru.collections.app.Entity.Collection;
import ru.collections.app.JavaFxApp;
import ru.collections.app.Service.CollectionService;
import ru.collections.app.Service.CollectionServiceImpl;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller
@FxmlView("/fxml/CollectionScene.fxml")
public class CollectionScene {



    CollectionService collectionService = new CollectionServiceImpl();

    @FXML
    public Label collectionName;
    @FXML
    public TextField card;
    @FXML
    private Button addCards;
    @FXML
    private ListView listNumericCards;
    @FXML
    private ListView listAlphabeticCards;
    @FXML
    private Label repeat;
    @FXML
    private Button back;

    private String user;

    private Collection collection;


    public void initialize() throws ExecutionException, InterruptedException {


    }


    public void viewCollection() throws ExecutionException, InterruptedException {
        if (collection.getAlphabetic() != null)
            for (int i = 1; i <= collection.getAlphabetic().getCards().size(); i++) {
                listAlphabeticCards.getItems().add(collection.getAlphabetic().getPrefix() + i + " : " + collection.getAlphabetic().getCards().get(collection.getAlphabetic().getPrefix() + i));
                listAlphabeticCards.setVisible(true);
            }
        for (int i = 1; i <= collection.getNumeric().size(); i++)
            listNumericCards.getItems().add(i + " : " + collection.getNumeric().get(String.valueOf(i)));
    }

    public void addCard(ActionEvent actionEvent) throws ExecutionException, InterruptedException {
        if (collection.getNumeric().get(card.getText()) != null) {
            collection.getNumeric().put(card.getText(), collection.getNumeric().get(card.getText()) + 1);
            listNumericCards.getItems().set(Integer.parseInt(card.getText()) - 1, Integer.parseInt(card.getText()) + " : " + collection.getNumeric().get(card.getText()));
        }
        if (!ObjectUtils.isEmpty(collection.getAlphabetic())) {
            collection.getAlphabetic().getCards().put(card.getText(), collection.getAlphabetic().getCards().get(card.getText()) + 1);
            listAlphabeticCards.getItems().set(Integer.parseInt(card.getText().replaceFirst(collection.getAlphabetic().getPrefix(), "")) - 1,
                    card.getText() + " : " + collection.getAlphabetic().getCards().get(card.getText()));
        }
        card.selectAll();
        collectionService.add(user, collection);
        repeat.setText(collectionService.sortByAmount(collection, 1));

    }

    public void deleteCard(ActionEvent actionEvent) throws ExecutionException, InterruptedException {
        if (collection.getNumeric().get(card.getText()) != null) {
            collection.getNumeric().put(card.getText(), collection.getNumeric().get(card.getText()) - 1);
            listNumericCards.getItems().set(Integer.parseInt(card.getText()) - 1, Integer.parseInt(card.getText()) + " : " + collection.getNumeric().get(card.getText()));
        }
        if (!ObjectUtils.isEmpty(collection.getAlphabetic())) {
            collection.getAlphabetic().getCards().put(card.getText(), collection.getAlphabetic().getCards().get(card.getText()) - 1);
            listAlphabeticCards.getItems().set(Integer.parseInt(card.getText().replaceFirst(collection.getAlphabetic().getPrefix(), "")) - 1,
                    card.getText() + " : " + collection.getAlphabetic().getCards().get(card.getText()));
        }
        card.selectAll();
        collectionService.add(user, collection);
        repeat.setText(collectionService.sortByAmount(collection, 1));
    }

    public void backScene(ActionEvent event) throws IOException, ExecutionException, InterruptedException {
        FXMLLoader loader = new FXMLLoader(JavaFxApp.class.getResource("/fxml/HomeScene.fxml"));
        Parent root = loader.load();
        HomeScene homeScene = loader.getController();
        homeScene.setUser(user);
        homeScene.setListCards();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public Label getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName.setText(collectionName);
    }

    public void setUser(String user) {
        this.user = user;
    }


    public void setCollection() {
        try {
            this.collection = collectionService.getCollection(this.user, collectionName.getText());

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        ;
    }

    public void setRepeat() {
        this.repeat.setText(collectionService.sortByAmount(collection, 1));
    }
}
