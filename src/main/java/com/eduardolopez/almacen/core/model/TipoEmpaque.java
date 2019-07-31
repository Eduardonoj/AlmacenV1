
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
@Table(name="tipo_empaque")
@NamedQueries(
        {
            @NamedQuery (name="TipoEmpaque.FindAll", query="select te from TipoEmpaque te"),
            

})
public class TipoEmpaque implements Serializable {
    
    
    private final LongProperty codigoEmpaque;
    
    
    private final StringProperty descripcion;

    public TipoEmpaque() {
        this.codigoEmpaque = new SimpleLongProperty();
        this.descripcion = new SimpleStringProperty();
    }

    public TipoEmpaque(Long codigoEmpaque, String descripcion) {
        this.codigoEmpaque = new SimpleLongProperty(codigoEmpaque);
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    @Id
    @Column(name="codigo_Empaque")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCodigoEmpaque() {
        return codigoEmpaque.get();
    }

    public void setCodigoEmpaque(Long codigoEmpaque) {
        this.codigoEmpaque.set(codigoEmpaque); 
    }

    @Column(name="descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion); 
    }
    
    
    
}
