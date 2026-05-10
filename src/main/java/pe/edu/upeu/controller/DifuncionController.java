package pe.edu.upeu.controller;

import jakarta.inject.Inject;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import pe.edu.upeu.model.Difuncion;
import pe.edu.upeu.service.DifuncionService;

public class DifuncionController {

    @FXML Button btnGuardar, btnActualizar, btnEliminar, btnSeleccionar;

    @FXML TextField txtnombreFallecido, txtfechaDifuncion, txtlugarDefuncion,
            txtcausaMuerte, txtnombreFamiliar, txtparentesco, txtBuscar;

    @FXML TableView<Difuncion> regDifuncionTabla;

    @FXML TableColumn<Difuncion, String> colnombreFallecido,
            colfechaDifuncion, colcausaMuerte,
            collugarDefuncion, colnombreFamiliar, colparentesco;

    ObservableList<Difuncion> datos;

    String idSeleccionado = "";

    @Inject
    DifuncionService cs;

    @FXML
    public void initialize() {
        listar();
        eventos();
        desacActBotton(true);
    }

    // 🔥 LISTAR
    private void listar() {
        colnombreFallecido.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getNombreFallecido()));

        colfechaDifuncion.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getFechaDefuncion()));

        colcausaMuerte.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getCausaMuerte()));

        collugarDefuncion.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getLugarDefuncion()));

        colnombreFamiliar.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getNombreFamiliar()));

        colparentesco.setCellValueFactory(c ->
                new SimpleStringProperty(c.getValue().getParentesco()));

        datos = FXCollections.observableArrayList(cs.findAll());
        regDifuncionTabla.setItems(datos);
    }

    // 🔥 GUARDAR / ACTUALIZAR
    private void guardar() {
        Difuncion d = new Difuncion();

        d.setNombreFallecido(txtnombreFallecido.getText());
        d.setFechaDefuncion(txtfechaDifuncion.getText());
        d.setLugarDefuncion(txtlugarDefuncion.getText());
        d.setCausaMuerte(txtcausaMuerte.getText());
        d.setNombreFamiliar(txtnombreFamiliar.getText());
        d.setParentesco(txtparentesco.getText());

        if (idSeleccionado.equals("")) {
            cs.save(d);
        } else {
            d.setId(idSeleccionado);
            cs.update(d);
            idSeleccionado = "";
        }

        limpiar();
        listar();
    }

    // 🔥 EVENTOS
    private void eventos() {

        btnGuardar.setOnAction(e -> guardar());

        btnActualizar.setOnAction(e -> guardar());

        btnEliminar.setOnAction(e -> {
            if (idSeleccionado != null && !idSeleccionado.isEmpty()) {
                cs.delete(idSeleccionado);
                limpiar();
                listar();
            }
        });

        btnSeleccionar.setOnAction(e -> {
            Difuncion d = regDifuncionTabla.getSelectionModel().getSelectedItem();

            if (d != null) {
                txtnombreFallecido.setText(d.getNombreFallecido());
                txtfechaDifuncion.setText(d.getFechaDefuncion());
                txtlugarDefuncion.setText(d.getLugarDefuncion());
                txtcausaMuerte.setText(d.getCausaMuerte());
                txtnombreFamiliar.setText(d.getNombreFamiliar());
                txtparentesco.setText(d.getParentesco());

                idSeleccionado = d.getId();
                desacActBotton(false);
            }
        });
    }

    private void limpiar() {
        txtnombreFallecido.clear();
        txtfechaDifuncion.clear();
        txtlugarDefuncion.clear();
        txtcausaMuerte.clear();
        txtnombreFamiliar.clear();
        txtparentesco.clear();
        idSeleccionado = "";
        regDifuncionTabla.getSelectionModel().clearSelection();
    }

    private void desacActBotton(boolean v) {
        btnActualizar.setDisable(v);
        btnEliminar.setDisable(v);
    }
}