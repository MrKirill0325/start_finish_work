package com.example.project.controller;

import com.example.project.Main;
import com.example.project.params.StartParam;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {

    @FXML
    private Button startWork;
    @FXML
    private Button finishWork;
    @FXML
    private Button params;


    @FXML
    private void openStartWorkScreen(ActionEvent event) throws IOException {
        FXMLLoader loadStartScreen = new FXMLLoader(Main.class.getResource("start_work.fxml"));
        Parent root = loadStartScreen.load();
        Stage stage = new Stage();
        stage.getIcons().add(new Image(StartParam.mainIcon));
        stage.setTitle("Начало смены");
        stage.setScene(new Scene(root, 550,650));
        stage.show();
    }

    @FXML
    private void openFinishWorkScreen(ActionEvent event) throws IOException {
        FXMLLoader loadStartScreen = new FXMLLoader(Main.class.getResource("finish_work.fxml"));
        Parent root = loadStartScreen.load();
        Stage stage = new Stage();
        stage.getIcons().add(new Image(StartParam.mainIcon));
        stage.setTitle("Окончание смены");
        stage.setScene(new Scene(root, 550,650));
        stage.show();
    }

    @FXML
    private void openParamsScreen(ActionEvent event) throws IOException {
        FXMLLoader loadStartScreen = new FXMLLoader(Main.class.getResource("params.fxml"));
        Parent root = loadStartScreen.load();
        Stage stage = new Stage();
        stage.getIcons().add(new Image(StartParam.mainIcon));
        stage.setTitle("Настройки");
        stage.setScene(new Scene(root, 550,650));
        stage.show();
    }
}
