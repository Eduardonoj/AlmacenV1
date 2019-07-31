
package com.eduardolopez.almacen.core.model;

import java.io.Serializable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
@Table (name="producto")
@NamedQueries(
        {
            @NamedQuery (name="Producto.FindAll", query="select pr from Producto pr"),
            @NamedQuery(name="Producto.findByCodigoProducto", query = "select pr from Producto pr where pr.codigoProducto = ?1")

})
public class Producto implements Serializable{
    
    private final LongProperty codigoProducto;
    private final ObjectProperty<Categoria> categoria;
    private final ObjectProperty<TipoEmpaque> tipoEmpaque;
    private final StringProperty descripcion;
    private final DoubleProperty precioUnitario;
    private final DoubleProperty precioPorDocena;
    private final DoubleProperty precioPorMayor;
    private final LongProperty existencia;
    private final StringProperty imagen;

    public Producto() {
        this.codigoProducto = new SimpleLongProperty();
        this.categoria = new SimpleObjectProperty<Categoria>();
        this.tipoEmpaque = new SimpleObjectProperty<TipoEmpaque>();
        this.descripcion = new SimpleStringProperty();
        this.precioUnitario = new SimpleDoubleProperty();
        this.precioPorDocena = new SimpleDoubleProperty();
        this.precioPorMayor = new SimpleDoubleProperty();
        this.existencia = new SimpleLongProperty();
        this.imagen = new SimpleStringProperty();
    }

    public Producto(Long codigoProducto, Categoria categoria, TipoEmpaque tipoEmpaque, String descripcion, Double precioUnitario, Double precioPorDocena, Double precioPorMayor, Long existencia, String imagen) {
        this.codigoProducto = new SimpleLongProperty(codigoProducto);
        this.categoria = new SimpleObjectProperty<Categoria>(categoria);
        this.tipoEmpaque = new SimpleObjectProperty<TipoEmpaque>(tipoEmpaque);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.precioUnitario = new SimpleDoubleProperty(precioUnitario);
        this.precioPorDocena = new SimpleDoubleProperty(precioPorDocena);
        this.precioPorMayor = new SimpleDoubleProperty(precioPorMayor);
        this.existencia = new SimpleLongProperty(existencia);
        this.imagen = new SimpleStringProperty(imagen);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="codigo_producto")
    public Long getCodigoProducto() {
        return codigoProducto.get();
    }

    public void setCodigoProducto(Long codigoProducto) {
        this.codigoProducto.set(codigoProducto);
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_categoria")
    public Categoria getCategoria() {
        return categoria.get();
    }

    public void setCategoria(Categoria categoria) {
        this.categoria.set(categoria);
    }

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_empaque")
    public TipoEmpaque getTipoEmpaque() {
        return tipoEmpaque.get();
    }

    public void setTipoEmpaque(TipoEmpaque tipoEmpaque) {
        this.tipoEmpaque.set(tipoEmpaque);
    }

    @Column (name="descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    @Column (name="precio_unitario")
    public Double getPrecioUnitario() {
        return precioUnitario.get();
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario.set(precioUnitario);
    }

    @Column (name="precio_por_docena")
    public Double getPrecioPorDocena() {
        return precioPorDocena.get();
    }

    public void setPrecioPorDocena(Double precioPorDocena) {
        this.precioPorDocena.set(precioPorDocena);
    }

    @Column (name="precio_por_mayor")
    public Double getPrecioPorMayor() {
        return precioPorMayor.get();
    }

    public void setPrecioPorMayor(Double precioPorMayor) {
        this.precioPorMayor.set(precioPorMayor);
    }

    @Column (name="existencia")
    public Long getExistencia() {
        return existencia.get();
    }

    public void setExistencia(Long existencia) {
        this.existencia.set(existencia);
    }

      @Column (name= "imagen")
    public String getImagen() {
        return imagen.get();
    }

    public void setImagen(String imagen) {
        this.imagen.set(imagen);
    }
    
    
}
