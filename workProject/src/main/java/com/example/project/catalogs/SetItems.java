package com.example.project.catalogs;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

import java.util.List;

public class SetItems {

    public void setItems(List<String> list, List<ComboBox<String>> cbList ){

        for (ComboBox<String> comboBox : cbList){
            comboBox.setItems(FXCollections.observableArrayList(list));
        }
    }

}
