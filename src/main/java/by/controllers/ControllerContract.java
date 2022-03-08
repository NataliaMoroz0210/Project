package by.controllers;

import by.models.Contract;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.time.LocalDate;



public class ControllerContract {

    @FXML
    private TableView<Contract> tableContracts;
    @FXML
    private TableColumn<Contract, LocalDate> labelDate;
    @FXML
    private TableColumn<Contract, String> labelNumber;
    @FXML
    private TableColumn<Contract, String> labelType;
    @FXML
    private TableColumn<Contract, String> labelDepartment;
    @FXML
    private TableColumn<Contract, Integer> labelReg;
    @FXML
    private TableColumn<Contract, LocalDate> labelStartDate;
    @FXML
    private TableColumn<Contract, LocalDate> labelFinishDate;
    @FXML
    private TableColumn<Contract, Double> labelSum;
    @FXML
    private TableColumn<Contract, String> labelSubject;
    @FXML
    private TableColumn<Contract, String> labelUnp;
    @FXML
    private TableColumn<Contract, String> labelName;
    @FXML
    private TableColumn<Contract, String> labelAddress;
    @FXML
    private TableColumn<Contract, String> labelBankDetails;
    @FXML
    private TableColumn<Contract, String> labelContacts;
    @FXML
    private TableColumn<Contract, String> labelResident;
    @FXML
    private TableColumn<Contract, String> labelSide;
    @FXML
    private TableColumn<Contract, String> labelTermsPayment;
    @FXML
    private Label user;

    public void initialize() {
        labelDate.setCellValueFactory(new PropertyValueFactory<Contract, LocalDate>("date"));
        labelNumber.setCellValueFactory(new PropertyValueFactory<Contract, String>("number"));
        labelType.setCellValueFactory(new PropertyValueFactory<Contract, String>("type"));
        labelDepartment.setCellValueFactory(new PropertyValueFactory<Contract, String>("department"));
        labelReg.setCellValueFactory(new PropertyValueFactory<Contract, Integer>("reg"));
        labelStartDate.setCellValueFactory(new PropertyValueFactory<Contract, LocalDate>("startDate"));
        labelFinishDate.setCellValueFactory(new PropertyValueFactory<Contract, LocalDate>("finishDate"));
        labelSum.setCellValueFactory(new PropertyValueFactory<Contract, Double>("sum"));
        labelSubject.setCellValueFactory(new PropertyValueFactory<Contract, String>("subject"));
        labelUnp.setCellValueFactory(new PropertyValueFactory<Contract, String>("unp"));
        labelName.setCellValueFactory(new PropertyValueFactory<Contract, String>("name"));
        labelAddress.setCellValueFactory(new PropertyValueFactory<Contract, String>("address"));
        labelBankDetails.setCellValueFactory(new PropertyValueFactory<Contract, String>("bankDetails"));
        labelContacts.setCellValueFactory(new PropertyValueFactory<Contract, String>("contacts"));
        labelResident.setCellValueFactory(new PropertyValueFactory<Contract, String>("resident"));
        labelSide.setCellValueFactory(new PropertyValueFactory<Contract, String>("side"));
        labelTermsPayment.setCellValueFactory(new PropertyValueFactory<Contract, String>("termsPayment"));
    }

    protected void onTransferData(ObservableList<Contract> contracts) {
        tableContracts.setItems(contracts);
        user.setText(Controller.activeUser.getLogin());
    }

}
