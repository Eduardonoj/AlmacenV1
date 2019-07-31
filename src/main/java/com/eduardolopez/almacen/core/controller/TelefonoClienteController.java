
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.TelefonoCliente;
import com.eduardolopez.almacen.core.service.TelefonoClienteService;
import com.eduardolopez.almacen.core.service.TelefonoClienteServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class TelefonoClienteController implements Initializable{
    private Principal principal;
    private TelefonoClienteService telefonoClienteService = new TelefonoClienteServiceImpl();
    private ObservableList<TelefonoCliente> lista;
    @FXML private TableView<TelefonoCliente> tblTelefonoCliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(telefonoClienteService.findAllTelefonoCliente());
        tblTelefonoCliente.setItems(lista);
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    
}
