package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.Proveedor;
import com.eduardolopez.almacen.core.service.ProveedorService;
import com.eduardolopez.almacen.core.service.ProveedorServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class ProveedorController implements Initializable {
    private Principal principal;
    private ProveedorService proveedorService = new ProveedorServiceImpl();     
    @FXML private TableView<Proveedor> tblProveedor;        
    @FXML private TableColumn<Proveedor,String> colNit;
    @FXML private TableColumn<Proveedor,String> colRazonSocial;
    @FXML private TableColumn<Proveedor,String> colDireccion;
    @FXML private TableColumn<Proveedor,String> colPaginaWeb;
    @FXML private TableColumn<Proveedor,String> colContacto;
    @FXML private TextField txtNit;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtContactoPrincipal;
    @FXML private TextField txtRazonSocial;
    @FXML private TextField txtPaginaWeb;
    @FXML private Button btnNuevo;
    @FXML private Button btnGuardar;
    @FXML private Button btnEliminar;
    @FXML private Button btnModificar;
    @FXML private Button btnReporte;
    @FXML private Button btnSalir;    
    private ObservableList<Proveedor> lista;
    private enum tipo {NUEVO,CANCELAR,GUARDAR,NINGUNO,MODIFICAR}
    private tipo tipoOperacion = tipo.NINGUNO;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(proveedorService.findAllProveedor());
        tblProveedor.setItems(lista);
        this.colNit.setCellValueFactory(cellData->cellData.getValue().nit());        
        this.colRazonSocial.setCellValueFactory(cellData->cellData.getValue().razonSocial());
        this.colDireccion.setCellValueFactory(cellData->cellData.getValue().direccion());
        this.colPaginaWeb.setCellValueFactory(cellData->cellData.getValue().paginaWeb());
        this.colContacto.setCellValueFactory(cellData->cellData.getValue().contactoPrincipal());
    }   
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    
    
    public void nuevo(){
        switch(tipoOperacion){
            case NINGUNO:
                this.activarDesactivarControles(true);
                this.limpiar();
                this.btnNuevo.setText("Cancelar");
                this.btnGuardar.setDisable(false);
                this.btnEliminar.setDisable(true);
                this.btnModificar.setDisable(true);
                this.btnReporte.setDisable(true);
                this.btnSalir.setDisable(true);
                this.tipoOperacion = tipo.NUEVO;
                break;
            case NUEVO:
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = tipo.NINGUNO;
                break;
            case MODIFICAR:
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.tipoOperacion = tipo.NINGUNO;
                break;
        }
    }

    public void modificar(){
        if(this.tblProveedor.getSelectionModel().getSelectedItem() != null){
            this.activarDesactivarControles(true);
            this.tipoOperacion = tipo.MODIFICAR;
            this.btnNuevo.setText("Cancelar");
            this.btnGuardar.setDisable(false);
            this.btnEliminar.setDisable(true);
            this.btnModificar.setDisable(true);
            this.btnReporte.setDisable(true);
            this.btnSalir.setDisable(true);
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar un registro");
        }
    }
    
    public void seleccionar(){
      txtNit.setText(tblProveedor.getSelectionModel().getSelectedItem().getNit());   
      txtDireccion.setText(tblProveedor.getSelectionModel().getSelectedItem().getDireccion());
      txtContactoPrincipal.setText(tblProveedor.getSelectionModel().getSelectedItem().getContactoPrincipal());
      txtRazonSocial.setText(tblProveedor.getSelectionModel().getSelectedItem().getRazonSocial());
      txtPaginaWeb.setText(tblProveedor.getSelectionModel().getSelectedItem().getPaginaWeb());
    }
    public void activarDesactivarControles(boolean tipo){
        this.txtNit.setEditable(tipo);
        this.txtDireccion.setEditable(tipo);
        this.txtContactoPrincipal.setEditable(tipo);
        this.txtRazonSocial.setEditable(tipo);
        this.txtPaginaWeb.setEditable(tipo);
    }
    public void limpiar(){
        this.txtNit.setText("");
        this.txtDireccion.setText("");
        this.txtContactoPrincipal.setText("");
        this.txtRazonSocial.setText("");
        this.txtPaginaWeb.setText("");
    }
    
    public void salir() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    public void eliminar(){
        if(this.tblProveedor.getSelectionModel().getSelectedItem() != null){
            
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "Esta seguro de eliminar el registro?",
                    "Eliminar",JOptionPane.YES_NO_OPTION);
            
            if(JOptionPane.YES_OPTION == respuesta){
                int index = this.tblProveedor.getSelectionModel().getSelectedIndex();
                Proveedor elemento = this.tblProveedor.getSelectionModel().getSelectedItem();                
                this.proveedorService.deleteProveedor(elemento);
                this.lista.remove(index);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar una elemento!!!");            
        }
    }
    public void guardar(){
        switch(tipoOperacion){
            case NUEVO:
                Proveedor nuevo = new Proveedor();
                nuevo.setNit(txtNit.getText());
                nuevo.setDireccion(txtDireccion.getText());
                nuevo.setContactoPrincipal(txtContactoPrincipal.getText());
                nuevo.setRazonSocial(txtRazonSocial.getText());
                nuevo.setPaginaWeb(txtPaginaWeb.getText());
                this.proveedorService.saveProveedor(nuevo);
                this.lista.add(nuevo);
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                JOptionPane.showMessageDialog(null,"Registro almacenado");
                this.activarDesactivarControles(false);
                break;
            case MODIFICAR:
                Proveedor proveedor = tblProveedor.getSelectionModel().getSelectedItem();
                proveedor.setNit(txtNit.getText());
                proveedor.setDireccion(txtDireccion.getText());
                proveedor.setContactoPrincipal(txtContactoPrincipal.getText());
                proveedor.setRazonSocial(txtRazonSocial.getText());
                proveedor.setPaginaWeb(txtPaginaWeb.getText());
                this.proveedorService.updateProveedor(proveedor);
                lista.set(tblProveedor.getSelectionModel().getSelectedIndex(),proveedor);
                JOptionPane.showMessageDialog(null,"Registro actualizado!!!");
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnSalir.setDisable(false);
                this.activarDesactivarControles(false);
                break;
        }
        this.tipoOperacion = tipo.NINGUNO;
    }
       
}