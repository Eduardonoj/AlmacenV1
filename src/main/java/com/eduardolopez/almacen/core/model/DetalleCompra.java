
package com.eduardolopez.almacen.core.model;

import java.io.Serializable;
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
@Table (name="detalle_compra")
@NamedQueries(
        {
            @NamedQuery (name="DetalleCompra.FindAll", query="select dc from DetalleCompra dc"),
            @NamedQuery(name="DetalleCompra.findByIdDetalle", query = "select dc from DetalleCompra dc where dc.idDetalle = ?1")

})

public class DetalleCompra implements Serializable{
   
    private final LongProperty idDetalle;
    
    private final ObjectProperty<Compra> compra;
    
    private final ObjectProperty<Producto> producto;
    
    private final LongProperty cantidad;
    
    private final DoubleProperty precio;

    public DetalleCompra() {
        this.idDetalle = new SimpleLongProperty();
        this.compra = new SimpleObjectProperty<Compra>();
        this.producto = new SimpleObjectProperty<Producto>();
        this.cantidad = new SimpleLongProperty();
        this.precio = new SimpleDoubleProperty();
    }

    public DetalleCompra(Long idDetalle, Compra compra, Producto producto, Long cantidad, Double precio) {
        this.idDetalle = new SimpleLongProperty(idDetalle);
        this.compra = new SimpleObjectProperty<Compra>(compra);
        this.producto = new SimpleObjectProperty<Producto>(producto);
        this.cantidad = new SimpleLongProperty(cantidad);
        this.precio = new SimpleDoubleProperty(precio);
    }

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle")
    public Long getIdDetalle() {
        return idDetalle.get();
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle.set(idDetalle);
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_compra")
    public Compra getCompra() {
        return compra.get();
    }

    public void setCompra(Compra compra) {
        this.compra.set(compra);
    }

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="id_producto")
    public Producto getProducto() {
        return producto.get();
    }

    public void setProducto(Producto producto) {
        this.producto.set(producto);
    }

    @Column(name="cantidad")
    public Long getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(Long cantidad) {
        this.cantidad.set(cantidad);
    }

    @Column(name="precio")
    public Double getPrecio() {
        return precio.get();
    }

    public void setPrecio(Double precio) {
        this.precio.set(precio);
    }
    
    
    
}
