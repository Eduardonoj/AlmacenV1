
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class DetalleCompraController implements Initializable{
    
    private Principal principal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    public void setPrincipal (Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal()throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
}
