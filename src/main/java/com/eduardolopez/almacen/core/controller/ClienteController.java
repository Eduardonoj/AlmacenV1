
package com.eduardolopez.almacen.core.controller;

import com.eduardolopez.almacen.core.model.Cliente;
import com.eduardolopez.almacen.core.service.ClienteService;
import com.eduardolopez.almacen.core.service.ClienteServiceImpl;
import com.eduardolopez.almacen.core.sistema.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;


public class ClienteController implements Initializable {
     private ClienteService clienteService = new ClienteServiceImpl();
    private Principal principal;
    @FXML private TableView<Cliente> tblCliente;
    @FXML private TableColumn<Cliente,String> colNit;
    @FXML private TableColumn<Cliente,String> colDpi;
    @FXML private TableColumn<Cliente, String> colNombre;
    @FXML private TableColumn<Cliente, String> colDireccion;
    @FXML private TextField txtNit;
    @FXML private TextField txtDpi;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDireccion;
    @FXML private Button btnNuevo;
    @FXML private Button btnGuardar;
    @FXML private Button btnEliminar;
    @FXML private Button btnModificar;
    @FXML private Button btnReporte;
    @FXML private Button btnRegresar;
    
    private ObservableList<Cliente> lista;
    private enum tipo {NUEVO,CANCELAR,GUARDAR,NINGUNO,MODIFICAR}
    private tipo tipoOperacion = tipo.NINGUNO;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lista = FXCollections.observableArrayList(clienteService.findAllCliente());
        tblCliente.setItems(lista);
        this.colNit.setCellValueFactory(cellData->cellData.getValue().nit());
        this.colDpi.setCellValueFactory(cellData->cellData.getValue().dpi() );
        this.colNombre.setCellValueFactory(cellData->cellData.getValue().nombre());
        this.colDireccion.setCellValueFactory(cellData->cellData.getValue().direccion());
        
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
    
    public void regresarVentanaPrincipal() throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    
    public void activarDesactivarControles(boolean tipo){
        this.txtNit.setEditable(tipo);
        this.txtDpi.setEditable(tipo);
        this.txtNombre.setEditable(tipo);
        this.txtDireccion.setEditable(tipo);
    }
    
    public void limpiar(){
        this.txtNit.setText("");
        this.txtDpi.setText("");
        this.txtNombre.setText("");
        this.txtDireccion.setText("");
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
                this.btnRegresar.setDisable(true);
                this.tipoOperacion = tipo.NUEVO;
                break;
            case NUEVO:
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnRegresar.setDisable(false);
                this.tipoOperacion = tipo.NINGUNO;
                break;
            case MODIFICAR:
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnRegresar.setDisable(false);
                this.tipoOperacion = tipo.NINGUNO;
                break;
        }
    }
     public void modificar(){
        if(this.tblCliente.getSelectionModel().getSelectedItem() != null){
            this.activarDesactivarControles(true);
            this.tipoOperacion = tipo.MODIFICAR;
            this.btnNuevo.setText("Cancelar");
            this.btnGuardar.setDisable(false);
            this.btnEliminar.setDisable(true);
            this.btnModificar.setDisable(true);
            this.btnReporte.setDisable(true);
            this.btnRegresar.setDisable(true);
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar un registro");
        }
    }
     
     public void seleccionar(){
         txtNit.setText(tblCliente.getSelectionModel().getSelectedItem().getNit());
         txtDpi.setText(tblCliente.getSelectionModel().getSelectedItem().getDpi());
         txtNombre.setText(tblCliente.getSelectionModel().getSelectedItem().getNombre());
         txtDireccion.setText(tblCliente.getSelectionModel().getSelectedItem().getDireccion());
     }
    public void regresar()throws IOException{
        this.principal.mostrarVentanaPrincipal();
    }
    public void eliminar(){
        if(this.tblCliente.getSelectionModel().getSelectedItem() != null){
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "Esta seguro de eliminar el registro?",
                    "Eliminar", JOptionPane.YES_NO_OPTION);
            if(JOptionPane.YES_OPTION == respuesta){
                int index = this.tblCliente.getSelectionModel().getSelectedIndex();
                Cliente elemento = this.tblCliente.getSelectionModel().getSelectedItem();
                this.clienteService.deleteCliente(elemento);
                this.lista.remove(index);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento!!!");
        }
    }
    
    public void guardar(){
        switch(tipoOperacion){
            case NUEVO:
            Cliente nuevo = new Cliente();
                nuevo.setNit(txtNit.getText());
                nuevo.setDpi(txtDpi.getText());
                nuevo.setNombre(txtNombre.getText());
                nuevo.setDireccion(txtDireccion.getText());
                this.clienteService.saveCliente(nuevo);
                this.lista.add(nuevo);
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnRegresar.setDisable(false);
                JOptionPane.showMessageDialog(null,"Registro almacenado");
                this.activarDesactivarControles(false);
                break;
            case MODIFICAR:
                Cliente cliente = tblCliente.getSelectionModel().getSelectedItem();
                cliente.setNit(txtNit.getText());
                cliente.setDpi(txtDpi.getText());
                cliente.setNombre(txtNombre.getText());
                cliente.setDireccion(txtDireccion.getText());
                this.clienteService.updateCliente(cliente);
                lista.set(tblCliente.getSelectionModel().getSelectedIndex(),cliente);
                JOptionPane.showMessageDialog(null,"Registro actualizado!!!");
                this.btnNuevo.setText("Nuevo");
                this.btnGuardar.setDisable(true);
                this.btnEliminar.setDisable(false);
                this.btnModificar.setDisable(false);
                this.btnReporte.setDisable(false);
                this.btnRegresar.setDisable(false);
                this.activarDesactivarControles(false);
                break;
        }
        this.tipoOperacion = tipo.NINGUNO;
    
        
    }
     
}
