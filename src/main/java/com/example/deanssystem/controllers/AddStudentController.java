package com.example.deanssystem.controllers;

import com.example.deanssystem.model.SensitiveData;
import com.example.deanssystem.model.Student;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sql.dao.StudentDAO;
import sql.tables.ConnectionFile;

import java.sql.Connection;


public class AddStudentController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField fieldOfStudyField;
    @FXML
    private TextField yearOfStartField;
    @FXML
    private TextField PESELField;
    @FXML
    private TextField dateOfBirthField;
    @FXML
    private TextField placeOfBirthField;
    @FXML
    private TextField motherNameField;
    @FXML
    private TextField fatherNameField;


    private StudentDAO studentDAO = new StudentDAO();



    @FXML
    private Button backToMenu;

    @FXML
    protected void onAddStudentButtonClick() {

        ConnectionFile connectionFile = null;

        try {
            String name = nameField.getText();
            String lastName = lastNameField.getText();
            int fieldOfStudy = Integer.parseInt(fieldOfStudyField.getText());
            int yearOfStart = Integer.parseInt(yearOfStartField.getText());

            String PESEL = PESELField.getText();
            String dateOfBirth = dateOfBirthField.getText();
            String placeOfBirth = placeOfBirthField.getText();
            String motherName = motherNameField.getText();
            String fatherName = fatherNameField.getText();

            Student student = new Student(name, lastName, fieldOfStudy, yearOfStart);
            SensitiveData sensitiveData = new SensitiveData(PESEL, dateOfBirth, placeOfBirth, motherName, fatherName);

            connectionFile = new ConnectionFile();
            if (connectionFile.open()) {
                Connection conn = connectionFile.getConn();
                boolean success = studentDAO.addStudentAndSensitiveData(conn, student, sensitiveData);
                if (!success) {
                    System.out.println("Couldn't add student and sensitive data");
                }
            } else {
                System.out.println("Can't open connection with database");
            }
        } catch (NumberFormatException e) {
            System.out.println("None numeric format " + e.getMessage());
        } finally {
            if (connectionFile != null) {
                connectionFile.close();
            }
        }
    }

    public void returnToMainMenu() {
        try {
            Parent mainMenu = FXMLLoader.load(getClass().getResource("/com/example/deanssystem/main_view.fxml"));
            Scene scene = new Scene(mainMenu);
            Stage stage = (Stage) backToMenu.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }



}
