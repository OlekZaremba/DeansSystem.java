package com.example.deanssystem.controllers;

import com.example.deanssystem.model.Student;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sql.dao.StudentDAO;
import sql.tables.ConnectionFile;

public class ShowStudentController {

    @FXML
    private TableView<Student> studentsTable;
    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> lastNameColumn;
    @FXML
    private TableColumn<Student, Integer> fieldOfStudyColumn;
    @FXML
    private TableColumn<Student, Integer> yearOfStartColumn;

    private StudentDAO studentDAO = new StudentDAO();

    public void initTable() {

        System.out.println("2nd initializer");
        idColumn.setCellValueFactory(new PropertyValueFactory<>(ConnectionFile.COLUMN_STUDENT_STUDENT_ID));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>(ConnectionFile.COLUMN_STUDENT_NAME));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>(ConnectionFile.COLUMN_STUDENT_LASTNAME));
        fieldOfStudyColumn.setCellValueFactory(new PropertyValueFactory<>(ConnectionFile.COLUMN_STUDENT_FIELD_OF_STUDY));
        yearOfStartColumn.setCellValueFactory(new PropertyValueFactory<>(ConnectionFile.COLUMN_STUDENT_YEAR_OF_START));

        studentsTable.setItems(FXCollections.observableArrayList(studentDAO.getAllStudents()));
    }
}


