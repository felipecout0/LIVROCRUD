package com.example.sysbiblioteca.controller;


import com.example.sysbiblioteca.model.services.LivroServices;
import com.example.sysbiblioteca.utils.Alerta;
import com.example.sysbiblioteca.utils.PathFXML;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {

        @FXML
        ScrollPane scrollPaneMain;
        @FXML
        VBox vBoxMain;
        @FXML
        MenuBar menuBarMain;
        @FXML
        Menu menuCadastro;
        @FXML
        Menu menuHelp;
        @FXML
        MenuItem menuItemLivros;
        @FXML
        MenuItem menuItemAbout;

        //******************************************************************************************************************
        // INITIALIZER
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }
        //******************************************************************************************************************
        // TRATAMENTO DE EVENTOS
        @FXML
        public void onCadastroLivroAction(){loadView("\\LivroView.fxml");}
        @FXML
        public void onHelpAboutAction(){
            Alerta.exibirAlerta("Biblioteca","About","Biblioteca V 1.0", Alert.AlertType.INFORMATION);
        }
        //******************************************************************************************************************
        // CARREGAMENTO DA VIEW
        public void loadView(String arquivoFXML){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                VBox vBox = fxmlLoader.load(new FileInputStream(PathFXML.pathBase() + arquivoFXML));

                vBoxMain.getChildren().clear();
                vBoxMain.getChildren().add(menuBarMain);
                vBoxMain.getChildren().addAll(vBox.getChildren());

                LivroController controller = fxmlLoader.getController();
                controller.setLivroServices(new LivroServices());
                controller.updateTableView();
                controller.tbLivro.prefHeightProperty().bind(vBoxMain.heightProperty());

            } catch (RuntimeException | IOException e) {
                Alerta.exibirAlerta("Error","Erro ao carregar a view",e.getMessage(), Alert.AlertType.ERROR);
            }
        }
}