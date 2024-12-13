package com.example.sysbiblioteca.utils;

import javafx.scene.control.Alert;

public class Alerta {
    public static void exibirAlerta(String title, String header, String content, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }
}
