package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button registration;

    @FXML
    private Button entrance;


    @FXML
    protected void onWriteTextButtonClick() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Info");
        alert.setHeaderText(login.getText());
        Optional<ButtonType> buttonType = alert.showAndWait();
        login.setText((buttonType.get().getText()));
    }

    @FXML
    public void onComboBoxButtonClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(comboBox.getValue());
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.getItems().setAll(
                "Исполнитель",
                "Руководитель отдела",
                "Юрист",
                "Бухгалтер",
                "Администратор"
        );
    }

//    @FXML
//    public void onComboBoxChanged(ActionEvent actionEvent) {
//        String selectedValue = comboBox.getSelectionModel().getSelectedItem();
//        System.out.println(selectedValue);
//    }
}

