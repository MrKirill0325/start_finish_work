package com.example.project.controller;

import com.example.project.Main;
import com.example.project.catalogs.CatalogReader;
import com.example.project.catalogs.SetItems;
import com.example.project.clipBoard.WorkWithClipBoard;
import com.example.project.message.Message;
import com.example.project.params.StartParam;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StartWorkController implements Initializable {

    SetItems setItems;
    CatalogReader catalogReader = new CatalogReader();

    private byte countEmployeeClick;
    private byte countChangeProductClickLineSix;
    private byte countChangeProductClickLineTwelve;
    private byte countChangeProductClickLineEighteen;

    ArrayList<String> employeeList = new ArrayList<>();
    ArrayList<String> productListLineSix = new ArrayList<>();
    ArrayList<String> productListLineTwelve = new ArrayList<>();
    ArrayList<String> productListLineEighteen = new ArrayList<>();

    private StringBuilder sendingMessage = new StringBuilder();

    public StringBuilder getSendingMessage() {
        return sendingMessage;
    }


    @FXML
    private CheckBox sixLineEmptyProduct;
    @FXML
    private CheckBox twelveLineEmptyProduct;
    @FXML
    private CheckBox eighteenLineEmptyProduct;

    @FXML
    private Button addEmployeeOnScreenButton;
    @FXML
    private Button deleteEmployeeOnScreenButton;
    //Product
    @FXML
    private Button addProductChangeSixLine;
    @FXML
    private Button deleteProductChangeSixLine;
    @FXML
    private Button addProductChangeTwelveLine;
    @FXML
    private Button deleteProductChangeTwelveLine;
    @FXML
    private Button addProductChangeEighteenLine;
    @FXML
    private Button deleteProductChangeEighteenLine;

    //Employee Box
    @FXML
    private ComboBox<String> firstEmployeeBox;
    @FXML
    private ComboBox<String> secondEmployeeBox;
    @FXML
    private ComboBox<String> thirdEmployeeBox;
    @FXML
    private ComboBox<String> fourthEmployeeBox;
    @FXML
    private ComboBox<String> fifthEmployeeBox;
    @FXML
    private ComboBox<String> sixthEmployeeBox;

    //Product Box
    //Line Six
    @FXML
    private ComboBox<String> sixLineProductBoxOne;
    @FXML
    private ComboBox<String> sixLineProductBoxTwo;
    @FXML
    private ComboBox<String> sixLineProductBoxThree;
    @FXML
    private ComboBox<String> sixLineProductBoxFor;
    @FXML
    private ComboBox<String> sixLineProductBoxFive;
    @FXML
    private ComboBox<String> sixLineProductBoxSix;
    //Line Twelve
    @FXML
    private ComboBox<String> twelveLineProductBoxOne;
    @FXML
    private ComboBox<String> twelveLineProductBoxTwo;
    @FXML
    private ComboBox<String> twelveLineProductBoxThree;
    @FXML
    private ComboBox<String> twelveLineProductBoxFor;
    @FXML
    private ComboBox<String> twelveLineProductBoxFive;
    @FXML
    private ComboBox<String> twelveLineProductBoxSix;
    //Line Eighteen
    @FXML
    private ComboBox<String> eighteenLineProductBoxOne;
    @FXML
    private ComboBox<String> eighteenLineProductBoxTwo;
    @FXML
    private ComboBox<String> eighteenLineProductBoxThree;
    @FXML
    private ComboBox<String> eighteenLineProductBoxFor;
    @FXML
    private ComboBox<String> eighteenLineProductBoxFive;
    @FXML
    private ComboBox<String> eighteenLineProductBoxSix;
    @FXML
    private Label message;

    private List<ComboBox<String>> boxesEmployee(){
        List<ComboBox<String>> emp = new ArrayList<>();
        emp.add(firstEmployeeBox);
        emp.add(secondEmployeeBox);
        emp.add(thirdEmployeeBox);
        emp.add(fourthEmployeeBox);
        emp.add(fifthEmployeeBox);
        emp.add(sixthEmployeeBox);
        return emp;
    }

    private List<ComboBox<String>> boxesProdLineSix(){
        List<ComboBox<String>> emp = new ArrayList<>();
        emp.add(sixLineProductBoxOne);
        emp.add(sixLineProductBoxTwo);
        emp.add(sixLineProductBoxThree);
        emp.add(sixLineProductBoxFor);
        emp.add(sixLineProductBoxFive);
        emp.add(sixLineProductBoxSix);
        return emp;
    }

    private List<ComboBox<String>> boxesProdLineTwelve(){
        List<ComboBox<String>> emp = new ArrayList<>();
        emp.add(twelveLineProductBoxOne);
        emp.add(twelveLineProductBoxThree);
        emp.add(twelveLineProductBoxTwo);
        emp.add(twelveLineProductBoxFor);
        emp.add(twelveLineProductBoxFive);
        emp.add(twelveLineProductBoxSix);
        return emp;
    }

    private List<ComboBox<String>> boxesProdLineEighteen(){
        List<ComboBox<String>> emp = new ArrayList<>();
        emp.add(eighteenLineProductBoxOne);
        emp.add(eighteenLineProductBoxThree);
        emp.add(eighteenLineProductBoxTwo);
        emp.add(eighteenLineProductBoxFor);
        emp.add(eighteenLineProductBoxFive);
        emp.add(eighteenLineProductBoxSix);
        return emp;
    }

    //присваивание значений каждому ComboBox с сотрудниками
    private void setItemsEmployeeBox(){
        setItems = new SetItems();
        setItems.setItems(employeeList, boxesEmployee());
    }

    //присваивание значений каждому ComboBox с продуктами
    private void setItemsProductBox(){
        setItems = new SetItems();

        setItems.setItems(productListLineSix, boxesProdLineSix());
        setItems.setItems(productListLineTwelve, boxesProdLineTwelve());
        setItems.setItems(productListLineEighteen, boxesProdLineEighteen());

    }

    //Инициализация Контроллера
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        visibleEmployeeBox();
        disableEmployeeButtons();
        visibleProductBoxLineSix();
        disableChangeProductButtonsLineSix();
        visibleProductBoxLineTwelve();
        disableChangeProductButtonsLineTwelve();
        visibleProductBoxLineEighteen();
        disableChangeProductButtonsLineEighteen();
        catalogReader.read(productListLineSix, StartParam.filePathProductLineSix);
        catalogReader.read(productListLineTwelve, StartParam.filePathProductLineTwelve);
        catalogReader.read(productListLineEighteen, StartParam.filePathProductLineEighteen);
        catalogReader.read(employeeList, StartParam.filePathEmployee);
        setItemsEmployeeBox();
        setItemsProductBox();
        //message.setStyle("-fx-background-color: #b8b1b0");
        //Подсказка при наведении мышки
        addEmployeeOnScreenButton.setTooltip(new Tooltip("Press the button"));

    }

    //Счетчик кликов Сотрудники инкремент
    @FXML
    private void employeeClickUp(ActionEvent event){
        countEmployeeClick++;
        disableEmployeeButtons();
        visibleEmployeeBox();
    }

    //Счетчик кликов Сотрудники декремент
    @FXML
    private void employeeClickDown(ActionEvent event){
        countEmployeeClick--;
        disableEmployeeButtons();
        visibleEmployeeBox();
    }

    //Счетчик кликов Перестройки 6 линия инкремент
    @FXML
    private void changeProductLineSixClickUp(ActionEvent event){
        countChangeProductClickLineSix++;
        disableChangeProductButtonsLineSix();
        visibleProductBoxLineSix();
    }

    //Счетчик кликов Перестройки 6 линия декремент
    @FXML
    private void changeProductLineSixClickDown(ActionEvent event){
        countChangeProductClickLineSix--;
        disableChangeProductButtonsLineSix();
        visibleProductBoxLineSix();
    }

    //Счетчик кликов Перестройки 12 линия инкремент
    @FXML
    private void changeProductLineTwelveClickUp(ActionEvent event){
        countChangeProductClickLineTwelve++;
        disableChangeProductButtonsLineTwelve();
        visibleProductBoxLineTwelve();
    }

    //Счетчик кликов Перестройки 12 линия декремент
    @FXML
    private void changeProductLineTwelveClickDown(ActionEvent event){
        countChangeProductClickLineTwelve--;
        disableChangeProductButtonsLineTwelve();
        visibleProductBoxLineTwelve();
    }

    //Счетчик кликов Перестройки 18 линия инкремент
    @FXML
    private void changeProductLineEighteenClickUp(ActionEvent event){
        countChangeProductClickLineEighteen++;
        disableChangeProductButtonsLineEighteen();
        visibleProductBoxLineEighteen();
    }

    //Счетчик кликов Перестройки 18 линия декремент
    @FXML
    private void changeProductLineEighteenClickDown(ActionEvent event){
        countChangeProductClickLineEighteen--;
        disableChangeProductButtonsLineEighteen();
        visibleProductBoxLineEighteen();
    }

    //CheckBox нет розлива 6 линия
    @FXML
    private void lineSixNotWorking(ActionEvent event){
        if (sixLineEmptyProduct.isSelected()){
            deleteProductChangeSixLine.setDisable(true);
            addProductChangeSixLine.setDisable(true);
            countChangeProductClickLineSix = 0;
            sixLineProductBoxOne.setVisible(false);
            visibleProductBoxLineSix();
        }else {
            addProductChangeSixLine.setDisable(false);
            sixLineProductBoxOne.setVisible(true);

        }
    }

    //CheckBox нет розлива 12 линия
    @FXML
    private void lineTwelveNotWorking(ActionEvent event) {
        if (twelveLineEmptyProduct.isSelected()) {
            deleteProductChangeTwelveLine.setDisable(true);
            addProductChangeTwelveLine.setDisable(true);
            countChangeProductClickLineTwelve = 0;
            twelveLineProductBoxOne.setVisible(false);
            visibleProductBoxLineTwelve();
        } else {
            addProductChangeTwelveLine.setDisable(false);
            twelveLineProductBoxOne.setVisible(true);

        }
    }

    //CheckBox нет розлива 18 линия
    @FXML
    private void lineEighteenNotWorking(ActionEvent event) {
        if (eighteenLineEmptyProduct.isSelected()) {
            deleteProductChangeEighteenLine.setDisable(true);
            addProductChangeEighteenLine.setDisable(true);
            countChangeProductClickLineEighteen = 0;
            eighteenLineProductBoxOne.setVisible(false);
            visibleProductBoxLineEighteen();
        } else {
            addProductChangeEighteenLine.setDisable(false);
            eighteenLineProductBoxOne.setVisible(true);

        }
    }



    //Деактивация кнопок добавления/удаления ComboBox с сотрудниками
    public void disableEmployeeButtons(){
        deleteEmployeeOnScreenButton.setDisable(countEmployeeClick == 0);
        addEmployeeOnScreenButton.setDisable(countEmployeeClick == 5);
    }

    //Деактивация кнопок добавления/удаления ComboBox с продуктами Линия 6
    public void disableChangeProductButtonsLineSix(){
        deleteProductChangeSixLine.setDisable(countChangeProductClickLineSix == 0);
        addProductChangeSixLine.setDisable(countChangeProductClickLineSix == 5);
    }

    //Деактивация кнопок добавления/удаления ComboBox с продуктами Линия 12
    public void disableChangeProductButtonsLineTwelve(){
        deleteProductChangeTwelveLine.setDisable(countChangeProductClickLineTwelve == 0);
        addProductChangeTwelveLine.setDisable(countChangeProductClickLineTwelve == 5);
    }

    //Деактивация кнопок добавления/удаления ComboBox с продуктами Линия 12
    public void disableChangeProductButtonsLineEighteen(){
        deleteProductChangeEighteenLine.setDisable(countChangeProductClickLineEighteen == 0);
        addProductChangeEighteenLine.setDisable(countChangeProductClickLineEighteen == 5);
    }

    //Видимость ComboBox с сотрудниками
    public void visibleEmployeeBox(){
        secondEmployeeBox.setVisible(countEmployeeClick >= 1);
        thirdEmployeeBox.setVisible(countEmployeeClick >= 2);
        fourthEmployeeBox.setVisible(countEmployeeClick >= 3);
        fifthEmployeeBox.setVisible(countEmployeeClick >= 4);
        sixthEmployeeBox.setVisible(countEmployeeClick >= 5);
    }

    //Видимость ComboBox с продуктами Линия 6
    public void visibleProductBoxLineSix(){
        sixLineProductBoxTwo.setVisible(countChangeProductClickLineSix >= 1);
        sixLineProductBoxThree.setVisible(countChangeProductClickLineSix >= 2);
        sixLineProductBoxFor.setVisible(countChangeProductClickLineSix >= 3);
        sixLineProductBoxFive.setVisible(countChangeProductClickLineSix >= 4);
        sixLineProductBoxSix.setVisible(countChangeProductClickLineSix >= 5);
    }

    //Видимость ComboBox с продуктами Линия 12
    public void visibleProductBoxLineTwelve(){
        twelveLineProductBoxTwo.setVisible(countChangeProductClickLineTwelve >= 1);
        twelveLineProductBoxThree.setVisible(countChangeProductClickLineTwelve >= 2);
        twelveLineProductBoxFor.setVisible(countChangeProductClickLineTwelve >= 3);
        twelveLineProductBoxFive.setVisible(countChangeProductClickLineTwelve >= 4);
        twelveLineProductBoxSix.setVisible(countChangeProductClickLineTwelve >= 5);
    }

    //Видимость ComboBox с продуктами Линия 18
    public void visibleProductBoxLineEighteen(){
        eighteenLineProductBoxTwo.setVisible(countChangeProductClickLineEighteen >= 1);
        eighteenLineProductBoxThree.setVisible(countChangeProductClickLineEighteen >= 2);
        eighteenLineProductBoxFor.setVisible(countChangeProductClickLineEighteen >= 3);
        eighteenLineProductBoxFive.setVisible(countChangeProductClickLineEighteen >= 4);
        eighteenLineProductBoxSix.setVisible(countChangeProductClickLineEighteen >= 5);
    }


    @FXML
    private void sendMessage(ActionEvent event) throws IOException {

        Message m = new Message();

        WorkWithClipBoard clipBoard = new WorkWithClipBoard();

        //StringBuilder builder = new StringBuilder();

        sendingMessage.append("На смене: ")
               .append(m.messageStartWorkGeneration(boxesEmployee(), StartParam.getPrefixEmployee()))
               .append("\n");

        if (sixLineEmptyProduct.isSelected()){
            sendingMessage.append("6 линия: нет розлива \n");
        }else {
            sendingMessage.append("6 линия: ")
               .append(m.messageStartWorkGeneration(boxesProdLineSix(), StartParam.getPrefixLine()))
               .append("\n");
        }

        if (twelveLineEmptyProduct.isSelected()){
            sendingMessage.append("12 линия: нет розлива \n");
        }else {
            sendingMessage.append("12 линия: ")
               .append(m.messageStartWorkGeneration(boxesProdLineTwelve(), StartParam.getPrefixLine()))
               .append("\n");
        }

        if (eighteenLineEmptyProduct.isSelected()){
            sendingMessage.append("18 линия: нет розлива \n");
        }else {
            sendingMessage.append("18 линия: ")
               .append(m.messageStartWorkGeneration(boxesProdLineEighteen(), StartParam.getPrefixLine()));
        }

//        if (!errorMessageController.stage.isShowing()){
//            FXMLLoader loadStartScreen = new FXMLLoader(Main.class.getResource("send_check.fxml"));
//            Parent root = loadStartScreen.load();
//            Stage stage = new Stage();
//            stage.getIcons().add(new Image(StartParam.mainIcon));
//            stage.setTitle("Начало смены");
//            stage.setScene(new Scene(root, 550,650));
//            stage.show();
//        }

        clipBoard.copy(sendingMessage.toString());

        message.setText(sendingMessage.toString());
    }


}
