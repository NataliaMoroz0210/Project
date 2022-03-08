package by.models;

import javafx.scene.control.PasswordField;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private String userType;
    private String login;
    private String department;
    private String password;
    private String status;

    public User(String userType, String login, String department, String password, String status) {
        this.userType = userType;
        this.login = login;
        this.department = department;
        this.password = password;
        this.status = status;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" +
                "userType='" + userType + '\'' +
                ", login='" + login + '\'' +
                ", department='" + department + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userType, user.userType) && Objects.equals(login, user.login) && Objects.equals(department, user.department) && Objects.equals(password, user.password) && Objects.equals(status, user.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userType, login, department, password, status);
    }
}


