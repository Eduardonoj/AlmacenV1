
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.TelefonoProveedor;
import com.eduardolopez.almacen.core.service.TelefonoProveedorService;
import com.eduardolopez.almacen.core.service.TelefonoProveedorServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class TelefonoProveedorController implements Initializable{
    private Principal principal;
    private TelefonoProveedorService telefonoProveedorService = new TelefonoProveedorServiceImpl();
    private ObservableList<TelefonoProveedor> lista;
    @FXML private TableView<TelefonoProveedor> tblTelefonoProveedor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(telefonoProveedorService.findAllTelefonoProveedor());
        tblTelefonoProveedor.setItems(lista);
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
}
