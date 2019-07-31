
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
@Table (name="detalle_factura")
@NamedQueries(
        {
            @NamedQuery (name="DetalleFactura.FindAll", query="select df from DetalleFactura df"),
            @NamedQuery(name="DetalleFactura.findByCodigoDetalle", query = "select df from DetalleFactura df where df.codigoDetalle = ?1")

})

public class DetalleFactura implements Serializable {
   
    private final LongProperty codigoDetalle;
    
    private final ObjectProperty<Factura> factura;
    
    private final ObjectProperty<Producto> producto;
    
    private final LongProperty cantidad;
    
    private final DoubleProperty precio;
    
    private final DoubleProperty descuento;

    public DetalleFactura() {
        this.codigoDetalle = new SimpleLongProperty();
        this.factura = new SimpleObjectProperty<Factura>();
        this.producto = new SimpleObjectProperty<Producto>();
        this.cantidad = new SimpleLongProperty();
        this.precio = new SimpleDoubleProperty();
        this.descuento = new SimpleDoubleProperty();
    }

    public DetalleFactura(Long codigoDetalle, Factura factura, Producto producto, Long cantidad, Double precio, Double descuento) {
        this.codigoDetalle = new SimpleLongProperty(codigoDetalle);
        this.factura = new SimpleObjectProperty<Factura>(factura);
        this.producto = new SimpleObjectProperty<Producto>(producto);
        this.cantidad = new SimpleLongProperty(cantidad);
        this.precio = new SimpleDoubleProperty(precio);
        this.descuento = new SimpleDoubleProperty(descuento);
    }

     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="codigo_detalle")
    public Long getCodigoDetalle() {
        return codigoDetalle.get();
    }

    public void setCodigoDetalle(Long codigoDetalle) {
        this.codigoDetalle.set(codigoDetalle); 
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="numero_factura")
    public Factura getFactura() {
        return factura.get();
    }

    public void setFactura(Factura factura) {
        this.factura.set(factura); 
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_producto")
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

    @Column(name="descuento")
    public Double getDescuento() {
        return descuento.get();
    }

    public void setDescuento(Double descuento) {
        this.descuento.set(descuento);
    }
    
    
    
}
