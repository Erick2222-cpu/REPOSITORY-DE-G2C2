package pe.edu.upeu.controller;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pe.edu.upeu.model.Defuncion;
import pe.edu.upeu.repository.DefuncionRepository;

import java.time.LocalDate;

public class DefuncionController {

    @FXML private TextField txtNombre;
    @FXML private DatePicker dpFecha;
    @FXML private TextField txtLugar;
    @FXML private TextField txtCausa;
    @FXML private TextField txtFamiliar;
    @FXML private TextField txtParentesco;
    @FXML private ListView<String> listView;


    private int index = -1;
    private int idSeleccionado = -1;
    private String id;

    @FXML
    public void guardar() {
        if (txtNombre.getText().isEmpty() || dpFecha.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "Complete los campos").show();
            return;
        }

        Defuncion d = new Defuncion(
                txtNombre.getText(),
                dpFecha.getValue(),
                txtLugar.getText(),
                txtCausa.getText(),
                txtFamiliar.getText(),
                txtParentesco.getText()
        );

        repo.guardar(d);
        listar();
        limpiar();
        System.out.println("Guardado ejecutado");
    }

    @FXML
    public void listar() {
        listView.getItems().clear();
        for (Defuncion d : repo.listar()) {
            listView.getItems().add(d.getNombreFallecido() + " - " + d.getFechaDefuncion());
        }
    }

    @FXML
    public void seleccionar() {
        index = listView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            Defuncion d = repo.listar().get(index);
            idSeleccionado = d.hashCode();

            txtNombre.setText(d.getNombreFallecido());
            dpFecha.setValue(d.getFechaDefuncion());
            txtLugar.setText(d.getLugarDefuncion());
            txtCausa.setText(d.getCausaMuerte());
            txtFamiliar.setText(d.getNombreFamiliar());
            txtParentesco.setText(d.getParentesco());
        }
    }

    @FXML
    public void actualizar() {
        if (idSeleccionado != -1) {
            repo.actualizar(idSeleccionado, new Defuncion(
                    txtNombre.getText(),
                    dpFecha.getValue(),
                    txtLugar.getText(),
                    txtCausa.getText(),
                    txtFamiliar.getText(),
                    txtParentesco.getText()
            ));
            listar();
        }


    }

    @FXML
    public void eliminar() {
        if (idSeleccionado != -1) {
            repo.eliminar(idSeleccionado);
            listar();
        }

    }

    public void limpiar() {
        txtNombre.clear();
        dpFecha.setValue(null);
        txtLugar.clear();
        txtCausa.clear();
        txtFamiliar.clear();
        txtParentesco.clear();
    }



    private DefuncionRepository repo = new DefuncionRepository();

    @FXML
    public void initialize() {
        listar()




;
    }



}
