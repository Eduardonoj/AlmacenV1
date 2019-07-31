
package com.eduardolopez.almacen.core.model;

import java.io.Serializable;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="telefono_cliente")
@NamedQueries(
        {
            @NamedQuery (name="TelefonoCliente.FindAll", query="select tc from TelefonoCliente tc")

})
public class TelefonoCliente implements Serializable {
    
    private final LongProperty codigoTelefono;
    
    private final StringProperty numero;
    
    private final StringProperty descripcion;
     
    private final ObjectProperty<Cliente> cliente;

    public TelefonoCliente() {
        this.codigoTelefono = new SimpleLongProperty();
        this.numero = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
        this.cliente = new SimpleObjectProperty<Cliente>();
    }

    public TelefonoCliente(Long codigoTelefono, String numero, String descripcion, Cliente cliente) {
        this.codigoTelefono = new SimpleLongProperty(codigoTelefono);
        this.numero = new SimpleStringProperty(numero);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.cliente = new SimpleObjectProperty<Cliente>(cliente);
    }

    @Id
    @Column (name="codigo_telefono")
    public Long getCodigoTelefono() {
        return codigoTelefono.get();
    }

    public void setCodigoTelefono(Long codigoTelefono) {
        this.codigoTelefono.set(codigoTelefono);
    }

    @Column (name="numero")
    public String getNumero() {
        return numero.get();
    }

    public void setNumero(String numero) {
        this.numero.set(numero); 
    }

    @Column (name="descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion); 
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="nit")       
    public Cliente getCliente() {
        return cliente.get();
    }

    public void setCliente(Cliente cliente) {
        this.cliente.set(cliente);
    }

   

    
    
}
