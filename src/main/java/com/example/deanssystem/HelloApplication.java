package com.example.deanssystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sql.tables.ConnectionFile;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main_view.fxml"));
        System.out.println("Just opened a window");
        Scene scene = new Scene(fxmlLoader.load(), 1300, 800);
        stage.setTitle("Dean's System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        ConnectionFile connectionFile = new ConnectionFile();
        if(!connectionFile.open()){
            System.out.println("Can't open conn file");
            return;
        }

        launch();

    }
}