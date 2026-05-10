package pe.edu.upeu.controller;

import io.micronaut.context.ApplicationContext;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

@Singleton
public class MainguiController {
    @FXML BorderPane bp;

    @FXML
    public void abrirDifunciones() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/main_cliente.fxml")
            );

            loader.setControllerFactory(context::getBean);

            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Inject
    ApplicationContext context;



    class MenuItemListener{
        Map<String, String[]> menus=Map.of(
                "menuItem1", new String[]{"/view/main_cliente.fxml", "Reg. Cliente", "T"},
                "menuItem2", new String[]{"/view/main_cliente.fxml", "Reg. Cliente", "T"},
                "menuItem3", new String[]{"/view/login.fxml", "Salir", "C"}
        );

        public void handle(ActionEvent e){
            String id=((MenuItem)e.getSource()).getId();
            if(menus.containsKey(id)){
                String[] items=menus.get(id);
                if(items[2].equals("C")){
                    Platform.exit();
                    System.exit(0);
                }else{
                    abrirTabPaneFXML(items[0],items[1]);
                }
            }
        }
        private void abrirTabPaneFXML(String fxmlPath, String tittle){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
                fxmlLoader.setControllerFactory(context::getBean);
                Parent root = fxmlLoader.load();
                ScrollPane scrollPane = new ScrollPane(root);
                scrollPane.setFitToWidth(true);
                scrollPane.setFitToHeight(true);
                Tab newTab = new Tab(tittle, scrollPane);
            }
            catch (IOException ex){
                throw new RuntimeException(ex);
            }
        }

    }


}
