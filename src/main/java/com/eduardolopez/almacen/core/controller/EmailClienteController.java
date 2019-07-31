
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.EmailCliente;
import com.eduardolopez.almacen.core.service.EmailClienteService;
import com.eduardolopez.almacen.core.service.EmailClienteServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;


public class EmailClienteController implements Initializable{
    private Principal principal;
private EmailClienteService emailClienteService = new EmailClienteServiceImpl();
    private ObservableList<EmailCliente> lista;
    @FXML private TableView<EmailCliente> tblEmailCliente;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(emailClienteService.findAllEmailCliente());
        tblEmailCliente.setItems(lista);
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
}
