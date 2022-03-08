package by.controllers;


import by.FxApplication;
import by.models.Contract;
import by.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.stage.Modality.WINDOW_MODAL;

public class ControllerExecutor {

    @FXML
    private Label user;
    @FXML
    private DatePicker date;
    @FXML
    private TextField number;
    @FXML
    private TextField type;
    @FXML
    private ComboBox<String> department;
    @FXML
    private TextField reg;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker finishDate;
    @FXML
    private TextField sum;
    @FXML
    private TextField subject;
    @FXML
    private TextField unp;
    @FXML
    private TextField name;
    @FXML
    private TextField address;
    @FXML
    private TextField bankDetails;
    @FXML
    private CheckBox resident;
    @FXML
    private CheckBox producer;
    @FXML
    private CheckBox customer;
    @FXML
    private RadioButton prepayment;
    @FXML
    private RadioButton delay;
    @FXML
    private RadioButton free;
    @FXML
    private Button registration;
    @FXML
    private Button find;
    @FXML
    private TextField comment;

    public static ObservableList<Contract> contracts = FXCollections.observableArrayList();

    protected void onTransferData() {
        user.setText(Controller.activeUser.getLogin());
    }


    @FXML
    protected void onRegistration(ActionEvent event) throws IOException {
//        Contract newContract = new Contract();
//        contracts.add(newContract);
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(FxApplication.class.getResource("tableContract.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Справочник договоров");
        stage.initModality(WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        ControllerContract controllerContract = loader.getController();
        controllerContract.onTransferData(contracts);
        stage.show();
    }
}
