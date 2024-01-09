package com.example.deanssystem.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Objects;

public class MainViewController {


    @FXML
    private Button addStudentButton;
    @FXML
    private Button showStudentButton;
    @FXML
    private AnchorPane contentPane;


    public void onAddStudentMenuClick() {
        switchContent("/com/example/deanssystem/add_student_view.fxml");
    }

    public void onShowStudentsMenuClick() {
        switchContent("/com/example/deanssystem/show_student_view.fxml");
    }

    private void switchContent(String pathToFxml) {
        try {
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(pathToFxml)));
            Node newContent = loader.load();
            contentPane.getChildren().setAll(newContent);

            if (loader.getController() instanceof ShowStudentController) {
                ShowStudentController controller = (ShowStudentController) loader.getController();
                controller.initTable();
            }
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }



    public void initialize() {
        System.out.println("Just initialized button");
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/add_student_icon.png")));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(24);
        imageView.setFitWidth(24);
        addStudentButton.setGraphic(imageView);


        Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/icons/show_students_icon.png")));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(24);
        imageView2.setFitWidth(24);
        showStudentButton.setGraphic(imageView2);

    }
}
