package by;

import by.controllers.Controller;
import by.helpers.MainControllerHelper;
import by.models.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FxApplication extends Application {

    private static final String SRC = "data.dat";


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sampleA.fxml")));
        primaryStage.setTitle("Авторизация");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        MainControllerHelper.readData(Controller.users, SRC);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        List<User> list = new ArrayList<>(Controller.users);
        MainControllerHelper.saveData(list, SRC);
    }
}
