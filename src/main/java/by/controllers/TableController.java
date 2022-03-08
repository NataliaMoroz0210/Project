package by.controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import by.models.User;

public class TableController {
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> labelUserType;
    @FXML
    private TableColumn<User, String> labelLogin;
    @FXML
    private TableColumn<User, String> labelDepartment;
    @FXML
    private TableColumn<User, String> status;
    @FXML
    private Button resetPassword;
    @FXML
    private Button confirmUserRights;
    @FXML
    private Label user;
    @FXML
    private Button add;
    @FXML
    private Button del;
    @FXML
    private Button change;


    public void initialize() {
        table.setEditable(true);
        labelUserType.setCellValueFactory(new PropertyValueFactory<User, String>("userType"));
        labelLogin.setCellValueFactory(new PropertyValueFactory<User, String>("login"));
        labelDepartment.setCellValueFactory(new PropertyValueFactory<User, String>("department"));
        status.setCellValueFactory(new PropertyValueFactory<User, String>("status"));
        labelLogin.setCellFactory(t -> {
            TableCell<User, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(labelLogin.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });

    }

    protected void onTransferData(ObservableList<User> users) {
        table.setItems(users);
        user.setText(Controller.activeUser.getLogin());
    }

    @FXML
    protected void onConfirmUserRights() {
        if (table.getSelectionModel().getSelectedItem() != null) {
            User selectedUser = table.getSelectionModel().getSelectedItem();
            selectedUser.setStatus("подтверждён");
            table.refresh();
        }
    }

    @FXML
    protected void add() {
        table.getItems().add(new User("Исполнитель", "Новый", "Новый", "123", "на согласовании"));
    }

    @FXML
    protected void del() {
        if (table.getSelectionModel().getSelectedItem() != null) {
            User selectedUser = table.getSelectionModel().getSelectedItem();
            table.getItems().remove(selectedUser);

        }

    }

    @FXML
    protected void onResetPassword() {
        if (table.getSelectionModel().getSelectedItem() != null) {
            User selectedUser = table.getSelectionModel().getSelectedItem();
            selectedUser.setPassword("123");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информация");
            alert.setHeaderText("Установлен пароль по умолчанию 123, рекомендается изменить");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onChange() {

        labelUserType.setCellValueFactory(new PropertyValueFactory<>("userType"));

        labelUserType.setCellFactory(TextFieldTableCell.<User>forTableColumn());

        labelUserType.setOnEditCommit((TableColumn.CellEditEvent<User, String> event) -> {
            TablePosition<User, String> pos = event.getTablePosition();
            String newUserType = event.getNewValue();
            int row = pos.getRow();
            User user = event.getTableView().getItems().get(row);
            user.setUserType(newUserType);
            table.refresh();
        });

        labelLogin.setCellValueFactory(new PropertyValueFactory<>("login"));

        labelLogin.setCellFactory(TextFieldTableCell.<User>forTableColumn());

        labelLogin.setOnEditCommit((TableColumn.CellEditEvent<User, String> event) -> {
            TablePosition<User, String> pos = event.getTablePosition();
            String newLogin = event.getNewValue();
            int row = pos.getRow();
            User user = event.getTableView().getItems().get(row);
            user.setLogin(newLogin);
            table.refresh();
        });

        labelDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));

        labelDepartment.setCellFactory(TextFieldTableCell.<User>forTableColumn());

        labelDepartment.setOnEditCommit((TableColumn.CellEditEvent<User, String> event) -> {
            TablePosition<User, String> pos = event.getTablePosition();
            String newDepartment = event.getNewValue();
            int row = pos.getRow();
            User user = event.getTableView().getItems().get(row);
            user.setDepartment(newDepartment);
            table.refresh();
        });
    }

}

