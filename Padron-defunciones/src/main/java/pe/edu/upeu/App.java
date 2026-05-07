package pe.edu.upeu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import pe.edu.upeu.config.CrearTabla;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        CrearTabla.crearTabla();

        FXMLLoader load = new FXMLLoader(
                getClass().getResource("/View/main.fxml")
        );

        Scene scene = new Scene(load.load(), 400, 300);

        // Estilo Bootstrap (como tu otro proyecto)
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());

        stage.setScene(scene);
        stage.setTitle("Padrón de Defunciones");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}