package com.example.project.controller;

import com.example.project.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ErrorMessageController implements Initializable {

    @FXML
    private Label labelMessage;
    @FXML
    private Button closeButton;

    Stage stage = new Stage();

    public void errorMessage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("errorMessage.fxml"));
        Parent root1 = fxmlLoader.load();
        stage.setScene(new Scene(root1, 231,170));
        stage.setTitle("Ошибка!");
        stage.show();

        //System.out.println("Не выбран сотрудник!!!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelMessage.setText("Заполнены не все поля!!!");
    }

    @FXML
    private void closeFrame(ActionEvent event){
        stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
