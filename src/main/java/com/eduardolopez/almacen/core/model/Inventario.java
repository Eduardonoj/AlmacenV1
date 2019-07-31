
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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="inventario")
@NamedQueries(
        {
            @NamedQuery (name="Inventario.FindAll", query="select i from Inventario i"),
            @NamedQuery(name="Inventario.findByCodigoInventario", query = "select i from Inventario i where i.codigoInventario = ?1")
                

})

public class Inventario implements Serializable {
    
    private final LongProperty codigoInventario;
    
    private final ObjectProperty<Producto> producto;
    
    private final ObjectProperty<Date> fecha;
    
    private final StringProperty tipoRegistro;
   
    private final DoubleProperty precio;
    
    private final LongProperty entradas;
    
    private final LongProperty salidas;

    public Inventario() {
        this.codigoInventario = new SimpleLongProperty();
        this.producto = new SimpleObjectProperty<Producto>();
        this.fecha = new SimpleObjectProperty<Date>();
        this.tipoRegistro = new SimpleStringProperty();
        this.precio = new SimpleDoubleProperty();
        this.entradas = new SimpleLongProperty();
        this.salidas = new SimpleLongProperty();
    }

    public Inventario(Long codigoInventario, Producto producto, Date fecha, String tipoRegistro, Double precio, Long entradas, Long salidas) {
        this.codigoInventario = new SimpleLongProperty(codigoInventario);
        this.producto = new SimpleObjectProperty<Producto>(producto);
        this.fecha = new SimpleObjectProperty<Date>(fecha);
        this.tipoRegistro = new SimpleStringProperty(tipoRegistro);
        this.precio = new SimpleDoubleProperty(precio);
        this.entradas = new SimpleLongProperty(entradas);
        this.salidas = new SimpleLongProperty(salidas);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo_inventario")
    public Long getCodigoInventario() {
        return codigoInventario.get();
    }

    public void setCodigoInventario(Long codigoInventario) {
        this.codigoInventario.set(codigoInventario); 
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_producto")
    public Producto getProducto() {
        return producto.get();
    }

    public void setProducto(Producto producto) {
        this.producto.set(producto); 
    }

    @Column(name="fecha")
    public Date getFecha() {
        return fecha.get();
    }

    
    public void setFecha(Date fecha) {
        this.fecha.set(fecha); 
    }

    @Column(name="tipo_registro")
    public String getTipoRegistro() {
        return tipoRegistro.get();
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro.set(tipoRegistro); 
    }

     @Column(name="precio")
    public Double getPrecio() {
        return precio.get();
    }

    public void setPrecio(Double precio) {
        this.precio.set(precio); 
    }

    @Column(name="entradas")
    public Long getEntradas() {
        return entradas.get();
    }

    public void setEntradas(Long entradas) {
        this.entradas.set(entradas);
    }

    @Column(name="salidas")
    public Long getSalidas() {
        return salidas.get();
    }

    public void setSalidas(Long salidas) {
        this.salidas.set(salidas); 
    }
    
    
}
