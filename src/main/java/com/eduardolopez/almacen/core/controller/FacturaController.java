
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.Factura;
import com.eduardolopez.almacen.core.service.FacturaService;
import com.eduardolopez.almacen.core.service.FacturaServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class FacturaController implements Initializable {
private Principal principal;

private FacturaService facturaService = new FacturaServiceImpl();
    private ObservableList<Factura> lista;
    @FXML private TableView<Factura> tblFactura;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(facturaService.findAllFactura());
        tblFactura.setItems(lista);
    }
 
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
}
