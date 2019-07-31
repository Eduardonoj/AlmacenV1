package com.eduardolopez.almacen.core.model;

import java.io.Serializable;
import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="compra")
@NamedQueries(
        {
            @NamedQuery(name="Compra.findAll", query="select co from Compra co"),
            @NamedQuery(name="Compra.findByIdCompra", query = "select co from Compra co where co.idCompra = ?1")
        }
)
public class Compra implements Serializable{
    
    private final LongProperty idCompra;
    private final LongProperty numeroDocumento;
    private final ObjectProperty<Proveedor> proveedor; 
    private final ObjectProperty<Date> fecha;
    private final DoubleProperty total;

    public Compra() {
        this.idCompra = new SimpleLongProperty();
        this.numeroDocumento = new SimpleLongProperty();
        this.proveedor = new SimpleObjectProperty<Proveedor>();
        this.fecha = new SimpleObjectProperty<Date> ();
        this.total = new SimpleDoubleProperty();
    }

    public Compra(Long idCompra, Long numeroDocumento, Proveedor proveedor, Date fecha, Double total) {
        this.idCompra = new SimpleLongProperty(idCompra);
        this.numeroDocumento = new SimpleLongProperty(numeroDocumento);
        this.proveedor = new SimpleObjectProperty<Proveedor>(proveedor);
        this.fecha = new SimpleObjectProperty<Date> (fecha);
        this.total = new SimpleDoubleProperty(total);
    }

    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_compra")
    public Long getIdCompra() {
        return idCompra.get();
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra.set(idCompra);
    }

    @Column(name="numero_documento")
    public Long getNumeroDocumento() {
        return numeroDocumento.get();
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento.set(numeroDocumento);
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_proveedor")
    public Proveedor getProveedor() {
        return proveedor.get();
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor.set(proveedor);
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
