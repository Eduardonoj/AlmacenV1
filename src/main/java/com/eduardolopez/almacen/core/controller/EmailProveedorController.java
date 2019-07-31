
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.EmailProveedor;
import com.eduardolopez.almacen.core.service.EmailProveedorService;
import com.eduardolopez.almacen.core.service.EmailProveedorServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class EmailProveedorController implements Initializable {
    private Principal principal;
    private EmailProveedorService emailProveedorService = new EmailProveedorServiceImpl();
    private ObservableList<EmailProveedor> lista;
    @FXML private TableView<EmailProveedor> tblEmailProveedor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(emailProveedorService.findAllEmailProveedor());
        tblEmailProveedor.setItems(lista);
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    
}
