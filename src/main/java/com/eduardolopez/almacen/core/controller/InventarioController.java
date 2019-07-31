
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.Inventario;
import com.eduardolopez.almacen.core.service.InventarioService;
import com.eduardolopez.almacen.core.service.InventarioServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class InventarioController implements Initializable {
    private Principal principal;
    private InventarioService clienteService = new InventarioServiceImpl();
    private ObservableList<Inventario> lista;
    @FXML private TableView<Inventario> tblInventario;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(clienteService.findAllInventario());
        tblInventario.setItems(lista);
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
}
