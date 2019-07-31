
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.Producto;
import com.eduardolopez.almacen.core.service.ProductoService;
import com.eduardolopez.almacen.core.service.ProductoServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class ProductoController implements Initializable{
    private Principal principal;
    private ProductoService productoService = new ProductoServiceImpl();
    private ObservableList<Producto> lista;
    @FXML private TableView<Producto> tblProducto;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(productoService.findAllProducto());
        tblProducto.setItems(lista);
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    
}
