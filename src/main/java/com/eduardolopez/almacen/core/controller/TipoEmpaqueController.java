
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.TipoEmpaque;
import com.eduardolopez.almacen.core.service.TipoEmpaqueService;
import com.eduardolopez.almacen.core.service.TipoEmpaqueServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class TipoEmpaqueController implements Initializable{
    private Principal principal;
     private TipoEmpaqueService tipoEmpaqueService = new TipoEmpaqueServiceImpl();
    private ObservableList<TipoEmpaque> lista;
    @FXML private TableView<TipoEmpaque> tblTipoEmpaque;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(tipoEmpaqueService.findAllTipoEmpaque());
        tblTipoEmpaque.setItems(lista);
        
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
}
