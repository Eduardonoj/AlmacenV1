
package com.eduardolopez.almacen.core.model;

import java.io.Serializable;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="categoria")
@NamedQueries(
        {
            @NamedQuery (name="Categoria.FindAll", query="select ca from Categoria ca"),
            @NamedQuery(name="Categoria.findByCodigoCategoria", query = "select ca from Categoria ca where ca.codigoCategoria = ?1")

})
public class Categoria implements Serializable {
    
    private final LongProperty codigoCategoria; 
    
   
    private final StringProperty descripcion;

    public Categoria() {
        this.codigoCategoria = new SimpleLongProperty ();
        this.descripcion = new SimpleStringProperty();
    }

    
    public Categoria(Long codigoCategoria, String descripcion) {
        this.codigoCategoria = new SimpleLongProperty (codigoCategoria);
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="codigo_categoria")
    public Long getCodigoCategoria() {
        return codigoCategoria.get();
    }

    public void setCodigoCategoria(Long codigoCategoria) {
        this.codigoCategoria.set(codigoCategoria);
    }

     @Column (name="descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }
    
}
