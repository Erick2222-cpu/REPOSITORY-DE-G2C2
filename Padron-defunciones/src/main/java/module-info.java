module pe.edu.upeu {
    requires javafx.controls;

    requires org.kordamp.bootstrapfx.core;
    requires javafx.fxml;
    requires java.sql;

    opens pe.edu.upeu.controller to javafx.fxml;
    opens pe.edu.upeu to javafx.fxml;

    opens pe.edu.upeu.model to javafx.base;

    exports pe.edu.upeu;
}