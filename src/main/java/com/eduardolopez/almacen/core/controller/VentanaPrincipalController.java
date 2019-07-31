package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class VentanaPrincipalController implements Initializable {
    private Principal principal;
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void mostrarVentanaProveedores() throws IOException{
        this.principal.mostrarVentanaProveedores();
    }
    public void mostrarVentanaClientes () throws IOException{
        this.principal.mostrarVentanaClientes();
    }
    public void mostrarVentanaCompras () throws IOException{
        this.principal.mostrarVentanaCompras();
    }
    
    public void mostrarVentanaProductos () throws IOException{
        this.principal.mostrarVentanaProductos();
    }
   public void mostrarVentanaFacturas () throws IOException{
       this.principal.mostrarVentanaFacturas();
   }
}
