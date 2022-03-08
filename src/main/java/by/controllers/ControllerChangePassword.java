package by.controllers;

import by.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerChangePassword {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    private Label labelOldPassword;

    @FXML
    private PasswordField oldPassword;

    @FXML
    private Label labelNewPassword;

    @FXML
    private PasswordField newPassword;

    @FXML
    private Label labelRepeatPassword;

    @FXML
    private PasswordField repeatPassword;

    @FXML
    private Button changePassword;

    @FXML
    private Label activeUser;

    @FXML
    protected void onChangePassword2() {
        if (oldPassword.getText().equals(user.getPassword()) && newPassword.getText().equals(repeatPassword.getText())) {
            user.setPassword(newPassword.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информация");
            alert.setHeaderText("Пароль успешно изменён");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информация");
            alert.setHeaderText("Пароли не совпадают!");
            alert.showAndWait();
        }
    }

    protected void onTransferData() {
        activeUser.setText(user.getLogin());
    }
}