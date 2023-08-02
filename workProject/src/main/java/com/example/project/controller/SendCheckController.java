package com.example.project.controller;

import com.example.project.clipBoard.WorkWithClipBoard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class SendCheckController implements Initializable {

    WorkWithClipBoard clipBoard = new WorkWithClipBoard();
    StartWorkController startWorkController = new StartWorkController();

    @FXML
    private Button accept;
    @FXML
    private Button cancel;
    @FXML
    private Label finishedMessage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

//    public void acceptMessage(ActionEvent event){
//        clipBoard.copy(startWorkController.getSendingMessage().toString());
//    }
}
