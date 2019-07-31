package com.eduardolopez.almacen.core.sistema;

import com.eduardolopez.almacen.core.controller.ClienteController;
import com.eduardolopez.almacen.core.controller.CompraController;
import com.eduardolopez.almacen.core.controller.FacturaController;
import com.eduardolopez.almacen.core.controller.ProductoController;
import com.eduardolopez.almacen.core.controller.ProveedorController;
import com.eduardolopez.almacen.core.controller.VentanaPrincipalController;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Principal extends Application {
    private final String PAQUETE_VISTA = "/com/eduardolopez/almacen/core/view/";
    private Stage escenarioPrincipal;
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        this.escenarioPrincipal = escenarioPrincipal;
         mostrarVentanaPrincipal();        
        //mostrarVentanaProveedores();
        this.escenarioPrincipal.setTitle("Sistema de control de Almacen V. 1.0");
        this.escenarioPrincipal.show();
    }
    
    public void mostrarVentanaPrincipal() throws IOException{
        VentanaPrincipalController main = (VentanaPrincipalController)cambiarEscena("VentanaPrincipalView.fxml",800,600);
        main.setPrincipal(this);
    }
    
    public void mostrarVentanaProveedores() throws IOException{
        ProveedorController proveedorController = 
                (ProveedorController)cambiarEscena("ProveedorView.fxml",602,458);
        proveedorController.setPrincipal(this);
    }
    
    
    public void mostrarVentanaClientes()throws IOException{
        ClienteController clienteController =
                (ClienteController) cambiarEscena("ClienteView.fxml",600,488);
        clienteController.setPrincipal(this);
    }
    
    public void mostrarVentanaProductos()throws IOException{
        ProductoController productoController =
                (ProductoController) cambiarEscena("ProductoView.fxml",764, 484 );
        productoController.setPrincipal(this);
    }
    
    public void mostrarVentanaCompras()throws IOException{
        CompraController compraController =
                (CompraController)cambiarEscena("CompraView.fxml",615, 405);
        compraController.setPrincipal(this);
    }
    
    public void mostrarVentanaFacturas()throws IOException{
        FacturaController facturaController =
                (FacturaController) cambiarEscena("FacturaView.fxml", 600, 544);
        facturaController.setPrincipal(this);
    }
    
    
    
    
    
       
    public Initializable cambiarEscena(String fxml, int ancho, int alto) 
            throws IOException{        
        Initializable resultado = null;
        //Cargador del archivo FXML
        FXMLLoader cargadorFXML = new FXMLLoader();
        //Asignacion del archivo logico
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA + fxml);                
        //Cargdor de fabrica para cargar el archivo FXML
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());        
        //Direccion de la ruta del archivo FXML
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA + fxml));        
        //Creacion de la escena
        Scene escena = new Scene((AnchorPane)cargadorFXML.load(archivo),ancho,alto);         
        //Asignacion de la escena en el escenario principal
        this.escenarioPrincipal.setScene(escena);
        //Ajustar el tamaño del escenario a la escena
        this.escenarioPrincipal.sizeToScene();
        //Retornar el objeto initializable del controlador
        resultado = (Initializable)cargadorFXML.getController();
        return resultado;
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }

   
}
