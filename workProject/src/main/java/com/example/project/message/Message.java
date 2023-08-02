package com.example.project.message;

import com.example.project.controller.ErrorMessageController;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.util.List;

public class Message {

    public StringBuilder messageStartWorkGeneration(List<ComboBox<String>> cBox, String str) throws IOException {

        StringBuilder builder = new StringBuilder();

        for (ComboBox<String> cb : cBox){
            if (cb.isVisible() && cb.getValue() != null){
                if (!builder.isEmpty()){
                    builder.append(str);
                }
                builder.append(cb.getValue());
            }else if (cb.isVisible() && cb.getValue() == null){
                ErrorMessageController errorMessageController = new ErrorMessageController();
                errorMessageController.errorMessage();
                //System.out.println("Не выбран сотрудник");
                return builder;
            }
        }

        return builder;
    }

    public StringBuilder messageFinishWorkGeneration(){
        return null;
    }
}
