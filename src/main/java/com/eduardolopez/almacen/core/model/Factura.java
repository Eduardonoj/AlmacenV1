
package com.eduardolopez.almacen.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="factura")
@NamedQueries(
        {
            @NamedQuery (name="Factura.FindAll", query="select f from Factura f"),
            @NamedQuery(name=".findByNnumeroFactura", query = "select f from Factura f where f.numeroFactura = ?1")

})

public class Factura implements Serializable {

private final LongProperty numeroFactura;

private final ObjectProperty<Cliente> cliente;

private final ObjectProperty<Date> fecha;

private final DoubleProperty total;

    public Factura() {
        this.numeroFactura = new SimpleLongProperty();
        this.cliente = new SimpleObjectProperty<Cliente>();
        this.fecha = new SimpleObjectProperty<Date>();
        this.total = new SimpleDoubleProperty();
    }

    public Factura(Long numeroFactura, Cliente cliente, Date fecha, Double total) {
        this.numeroFactura = new SimpleLongProperty(numeroFactura);
        this.cliente = new SimpleObjectProperty<Cliente>(cliente);
        this.fecha = new SimpleObjectProperty<Date>(fecha);
        this.total = new SimpleDoubleProperty(total);
    }

    
    @Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
@Column(name="numero_factura")
    public Long getNumeroFactura() {
        return numeroFactura.get();
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura.set(numeroFactura); 
    }

    @ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="nit")
    public Cliente getCliente() {
        return cliente.get();
    }

    public void setCliente(Cliente cliente) {
        this.cliente.set(cliente); 
    }

    @Column(name="fecha")
    public Date getFecha() {
        return fecha.get();
    }

    public void setFecha(Date fecha) {
        this.fecha.set(fecha); 
    }

    @Column(name="total")
    public Double getTotal() {
        return total.get();
    }

    public void setTotal(Double total) {
        this.total.set(total);
    }
    
    



}
