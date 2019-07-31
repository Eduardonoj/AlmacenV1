
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.Categoria;
import com.eduardolopez.almacen.core.service.CategoriaService;
import com.eduardolopez.almacen.core.service.CategoriaServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class CategoriaController implements Initializable {
    private Principal principal;
    private CategoriaService categoriaService = new CategoriaServiceImpl();
    private ObservableList<Categoria> lista;
    @FXML private TableView<Categoria> tblCategoria;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(categoriaService.findAllCategoria());
        tblCategoria.setItems(lista);
    }   
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
        
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    
    }
    
    
}
