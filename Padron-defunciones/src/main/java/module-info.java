module pe.edu.upeu {
    requires javafx.controls;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.fxml;

    opens pe.edu.upeu.controller to javafx.fxml;
    opens pe.edu.upeu to javafx.fxml;

    exports pe.edu.upeu;
}