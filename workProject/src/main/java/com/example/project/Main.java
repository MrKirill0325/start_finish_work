package com.example.project;

import com.example.project.params.StartParam;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage stageMainScreen;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.stageMainScreen = primaryStage;
        this.stageMainScreen.getIcons().add(new Image(StartParam.mainIcon));
        this.stageMainScreen.setTitle("Начало/окончание смены");
        this.stageMainScreen.centerOnScreen();
        showMainView();
    }

    private void showMainView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main_screen.fxml"));
        BorderPane mainLayout = fxmlLoader.load();
        Scene scene = new Scene(mainLayout, 400, 300);
        //mainLayout.setStyle("-fx-background-color: #b8b1b0");
        stageMainScreen.setScene(scene);
        stageMainScreen.show();
    }

    public static void main(String[] args) {
        launch();
    }
}