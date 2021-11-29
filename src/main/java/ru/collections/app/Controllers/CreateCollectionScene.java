package ru.collections.app.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Controller;
import ru.collections.app.JavaFxApp;
import ru.collections.app.Service.CollectionService;
import ru.collections.app.Service.CollectionServiceImpl;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller
@FxmlView("/fxml/CreateCollectionScene.fxml")
public class CreateCollectionScene {



    CollectionService collectionService = new CollectionServiceImpl();

    @FXML
    private TextField name;
    @FXML
    private TextField amount;
    @FXML
    private CheckBox alphabetic;
    @FXML
    private TextField alphabeticPrefix;
    @FXML
    private TextField alphabeticAmount;
    @FXML
    private Button apply;
    @FXML
    private Button back;

    private String user;

    public void create(ActionEvent event) throws IOException, ExecutionException, InterruptedException {
        if (alphabetic.isSelected())
            collectionService.create(user, name.getText(), Integer.valueOf(amount.getText()), alphabeticPrefix.getText(), Integer.valueOf(alphabeticAmount.getText()));
        else
            collectionService.create(user, name.getText(), Integer.valueOf(amount.getText()));

        Thread.sleep(2000);
        FXMLLoader loader = new FXMLLoader(JavaFxApp.class.getResource("/fxml/HomeScene.fxml"));
        Parent root = loader.load();
        HomeScene homeScene = loader.getController();
        homeScene.setUser((user));
        homeScene.setListCards();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void setUser(String user) {
        this.user = user;
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
}
