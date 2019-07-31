
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
@Table (name="email_cliente")
@NamedQueries(
        {
            @NamedQuery (name="EmailCliente.FindAll", query="select ec from EmailCliente ec"),
            

})
public class EmailCliente implements Serializable {
  
    private final LongProperty codigoEmail;
    
    private final StringProperty email;
    
    private final ObjectProperty<Cliente> cliente;

    public EmailCliente() {
        this.codigoEmail = new SimpleLongProperty();
        this.email = new SimpleStringProperty();
        this.cliente = new SimpleObjectProperty<Cliente>();
    }

    public EmailCliente(Long codigoEmail, String email, Cliente cliente) {
        this.codigoEmail = new SimpleLongProperty(codigoEmail);
        this.email = new SimpleStringProperty(email);
        this.cliente = new SimpleObjectProperty<Cliente>(cliente);
    }

      @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name="nit")
    public Cliente getCliente() {
        return cliente.get();
    }

    public void setCliente(Cliente cliente) {
        this.cliente.set(cliente);
    }
    
    
}
