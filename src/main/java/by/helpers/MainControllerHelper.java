package by.helpers;

import by.models.User;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainControllerHelper {

    public static <T> void saveData(List<T> data, String src) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(src))) {
            output.writeObject(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static <T> void readData(ObservableList<T> data, String src) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(src))) {
            ArrayList<T> list = (ArrayList<T>) input.readObject();
            data.addAll(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}