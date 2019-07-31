/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table (name="email_proveedor")
@NamedQueries(
        {
            @NamedQuery (name="EmailProveedor.FindAll", query="select ep from EmailProveedor ep")

})
public class EmailProveedor implements Serializable {
    
    private final LongProperty codigoEmail;
    
    private final StringProperty email;
    
    private final ObjectProperty<Proveedor> proveedor;

    public EmailProveedor() {
        this.codigoEmail = new SimpleLongProperty();
        this.email = new SimpleStringProperty();
        this.proveedor = new SimpleObjectProperty<Proveedor>();
    }

    public EmailProveedor(Long codigoEmail, String email, Proveedor proveedor) {
        this.codigoEmail = new SimpleLongProperty(codigoEmail);
        this.email = new SimpleStringProperty(email);
        this.proveedor = new SimpleObjectProperty<Proveedor>(proveedor);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="codigo_email")
    public Long getCodigoEmail() {
        return codigoEmail.get();
    }

    public void setCodigoEmail(Long codigoEmail) {
        this.codigoEmail.set(codigoEmail); 
    }

    @Column (name="email")
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email); 
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="codigo_proveedor")
    public Proveedor getProveedor() {
        return proveedor.get();
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor.set(proveedor); 
    }

    
}
