package pe.edu.upeu.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx .scene.Parent;

public class MainController {

    @FXML
    public void abrirDefunciones() {
        System.out.println("Botón funciona");
        try {
            Parent root = FXMLLoader.load(
                    getClass().getResource("/View/defuncion.fxml")
            );

            Stage stage = new Stage();
            stage.setTitle("Registro de Defunciones");
            stage.setScene(new Scene(root, 400, 500));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

