package com.example.sysbiblioteca;

import com.example.sysbiblioteca.utils.PathFXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;

public class MainApp extends Application {
    @Getter
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println(PathFXML.pathBase());
        FXMLLoader fxmlLoader = new FXMLLoader();

        Parent root = fxmlLoader.load(new FileInputStream(PathFXML.pathBase() + "\\MainView.fxml"));
        scene = new Scene(root, 800, 550);

        ScrollPane scrollPane = (ScrollPane) scene.getRoot();
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);

        stage.setTitle("SYSBiblioteca!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}