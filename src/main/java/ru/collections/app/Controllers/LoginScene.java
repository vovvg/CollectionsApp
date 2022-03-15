package ru.collections.app.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.collections.app.JavaFxApp;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class LoginScene {

    @FXML
    private TextField user;


    public void onLogin(ActionEvent event) throws IOException, ExecutionException, InterruptedException {
        FXMLLoader loader = new FXMLLoader(JavaFxApp.class.getResource("/fxml/HomeScene.fxml"));
        Parent root = loader.load();
        HomeScene homeScene = loader.getController();
        homeScene.setUser((user.getText()));
        homeScene.setListCards();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}