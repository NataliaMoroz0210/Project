package by.controllers;

import by.FxApplication;
import by.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.stage.Modality.WINDOW_MODAL;

public class Controller implements Initializable {

    public static ObservableList<User> users = FXCollections.observableArrayList();
    TableController tableController;
    ControllerContract controllerContract;
    ControllerChangePassword controllerChangePassword;

    public static User activeUser;


    @FXML
    private ComboBox<String> userType;
    @FXML
    private ComboBox<String> department;
    @FXML
    private Label labelUserType;
    @FXML
    private TextField login;
    @FXML
    private Label labelDepartment;
    @FXML
    private Label labelLogin;
    @FXML
    private PasswordField password;
    @FXML
    private Label labelPassword;
    @FXML
    private Button registration;
    @FXML
    private Button entrance;
    @FXML
    private Button changePassword;

    @FXML
    protected void onComboBoxButtonClick1() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(userType.getValue());
        alert.showAndWait();
    }

    @FXML
    protected void onComboBoxButtonClick2() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(department.getValue());
        alert.showAndWait();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        userType.getItems().setAll(
                "Исполнитель",
                "Руководитель отдела",
                "Юрист",
                "Бухгалтер",
                "Администратор"
        );

        userType.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {

            if (newValue != null) {
                department.setDisable(newValue.equals("Администратор"));
                if (newValue.equals("Администратор")) {
                    department.setValue("Администратор");
                }
            }
        });

        department.getItems().setAll(
                "Отдел продаж",
                "Производство",
                "АХО"
        );
    }

    @FXML
    protected void onRegistration() throws IOException {
        try {
            List<String> list = onReadTable();
            if (!list.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Информация");
                alert.setHeaderText("Не заполнены поля: " + list.toString());
                alert.showAndWait();
            } else {
                for (User user : users) {
                    if (user.getLogin().equals(login.getText())) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Информация");
                        alert.setHeaderText("Пользователь с логином " + login.getText() + " зарегистрирован ранее");
                        alert.showAndWait();
                        return;
                    }
                }
                User newUser = new User(userType.getSelectionModel().getSelectedItem(), login.getText(), department.getSelectionModel().getSelectedItem(), password.getText(), "на согласовании");
                users.add(newUser);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Информация");
                alert.setHeaderText("Ваша заявка на регистрацию отправлена на согласование администратору");
                alert.showAndWait();
            }
        } catch (Exception e) {
            User newUser = new User(userType.getSelectionModel().getSelectedItem(), login.getText(), department.getSelectionModel().getSelectedItem(), password.getText(), "на согласовании");
            users.add(newUser);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информация");
            alert.setHeaderText("Ваша заявка на регистрацию отправлена на согласование администратору");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onTableWindowShow(ActionEvent event) throws IOException {
        FXMLLoader loader;
        User newUser = new User(userType.getSelectionModel().getSelectedItem(), login.getText(), department.getSelectionModel().getSelectedItem(), password.getText(), "подтверждён");
        for (User user : users) {
            if (user.equals(newUser)) {
                activeUser = user;
                if (userType.getValue().equals("Администратор")) {
                    Stage stage = new Stage();
                    loader = new FXMLLoader(FxApplication.class.getResource("tableA.fxml"));
                    stage.setScene(new Scene(loader.load()));
                    stage.setTitle("Список пользователей");
                    stage.initModality(WINDOW_MODAL);
                    stage.initOwner(((Node) event.getSource()).getScene().getWindow());
                    tableController = loader.getController();
                    tableController.onTransferData(users);
                    stage.show();
                    return;
                }
                if (userType.getValue().equals("Исполнитель")) {
                    Stage stage = new Stage();
                    loader = new FXMLLoader(FxApplication.class.getResource("sampleP.fxml"));
                    stage.setScene(new Scene(loader.load()));
                    stage.setTitle("Регистрация договора");
                    stage.initModality(WINDOW_MODAL);
                    stage.initOwner(((Node) event.getSource()).getScene().getWindow());
                    controllerContract = loader.getController();
                    stage.show();
                    return;
                }
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("Пользователь с такими параметрами отсутствует");
        alert.showAndWait();
    }

    protected List<String> onReadTable() {
        List<String> list = new ArrayList<>();
        if (userType.getSelectionModel().getSelectedItem() == null) {
            list.add(labelUserType.getText());
        }
        if (login.getText().isEmpty()) {
            list.add(labelLogin.getText());
        }
        if (department.getSelectionModel().getSelectedItem() == null) {
            list.add(labelDepartment.getText());
        }
        if (password.getText().isEmpty()) {
            list.add(labelPassword.getText());
        }
        return list;
    }

    @FXML
    protected void onChangePassword(ActionEvent event) throws IOException {
        User newUser = new User(userType.getSelectionModel().getSelectedItem(), login.getText(), department.getSelectionModel().getSelectedItem(), password.getText(), "подтверждён");
        for (User user : users) {
            if (user.equals(newUser)) {
                activeUser = user;
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(FxApplication.class.getResource("sampleCP.fxml"));
                stage.setScene(new Scene(loader.load()));
                stage.setTitle("Смена пароля пользователя");
                stage.initModality(WINDOW_MODAL);
                stage.initOwner(((Node) event.getSource()).getScene().getWindow());
                controllerChangePassword = loader.getController();
                controllerChangePassword.setUser(activeUser);
                controllerChangePassword.onTransferData();
                stage.show();
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("Пользователь с такими параметрами отсутствует");
        alert.showAndWait();
    }

}

