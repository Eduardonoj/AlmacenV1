
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.Compra;
import com.eduardolopez.almacen.core.service.CompraService;
import com.eduardolopez.almacen.core.service.CompraServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class CompraController implements Initializable {

    private Principal principal;
    private CompraService compraService = new CompraServiceImpl();
    private ObservableList<Compra> lista;
    @FXML private TableView<Compra> tblCompra;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(compraService.findAllCompra());
        tblCompra.setItems(lista);
        
    }
    
     public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    
    }
    
}
