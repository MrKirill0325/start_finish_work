package com.example.project.controller;

import com.example.project.clipBoard.WorkWithClipBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FinishWorkController implements Initializable {
    @FXML
    private TextField safetyField;
    @FXML
    private TextField qualityField;
    @FXML
    private TextField tagWriteField;
    @FXML
    private TextField tagCloseField;

    @FXML
    private TextArea sixLineArea;
    @FXML
    private TextArea twelveLineArea;
    @FXML
    private TextArea eighteenLineArea;
    @FXML
    private TextArea noteArea;

    @FXML
    private CheckBox sixLineCheck;
    @FXML
    private CheckBox twelveLineCheck;
    @FXML
    private CheckBox eighteenLineCheck;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //Установка флажка "Нет замечаний" - 6 линия
    @FXML
    private void noCommentsSixLine(ActionEvent event){
        sixLineArea.setDisable(sixLineCheck.isSelected());
    }

    //Установка флажка "Нет замечаний" - 12 линия
    @FXML
    private void noCommentsTwelveLine(ActionEvent event){
        twelveLineArea.setDisable(twelveLineCheck.isSelected());
    }

    //Установка флажка "Нет замечаний" - 18 линия
    @FXML
    private void noCommentsEighteenLine(ActionEvent event){
        eighteenLineArea.setDisable(eighteenLineCheck.isSelected());
    }

    @FXML
    private void sendMessageFinishWork(){

        StringBuilder builder = new StringBuilder();
        WorkWithClipBoard clipBoard = new WorkWithClipBoard();

        builder.append("Безопасность: ").append(safetyField.getText()).append("\n");

        builder.append("Качество: ").append(qualityField.getText())
                .append("\n");
        builder.append("Метки написано: ").append(tagWriteField.getText())
                .append("\n");
        builder.append("Метки закрыто: ").append(tagCloseField.getText())
                .append("\n");

        if (!sixLineCheck.isSelected()){
            builder.append("6 линия: ").append(sixLineArea.getText())
                    .append("\n");
        }else {
            builder.append("6 линия: ").append("без замечаний")
                    .append("\n");
        }

        if (!twelveLineCheck.isSelected()){
            builder.append("12 линия: ").append(twelveLineArea.getText())
                    .append("\n");
        }else {
            builder.append("12 линия: ").append("без замечаний")
                    .append("\n");
        }

        if (!eighteenLineCheck.isSelected()){
            builder.append("18 линия: ").append(eighteenLineArea.getText())
                    .append("\n");
        }else {
            builder.append("18 линия: ").append("без замечаний")
                    .append("\n");
        }

        if (!noteArea.getText().isEmpty()){
            builder.append("Примечание: ").append(noteArea.getText());
        }

        clipBoard.copy(builder.toString());

        System.out.println(builder.toString());
    }




}
