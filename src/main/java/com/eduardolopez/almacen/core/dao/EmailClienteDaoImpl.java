
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.EmailCliente;
import java.util.List;


public class EmailClienteDaoImpl implements EmailClienteDao {

    @Override
    public List<EmailCliente> findAllEmailCliente() {
         return (List<EmailCliente>) Conexion.getInstancia().findAll(EmailCliente.class);
    }

    @Override
    public EmailCliente findById(Long codigoEmail) {
         return (EmailCliente) Conexion.getInstancia().findById(EmailCliente.class, codigoEmail);
    }

    @Override
    public void saveEmailCliente(EmailCliente elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteEmailCliente(EmailCliente elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateEmailCliente(EmailCliente elemento) {
       Conexion.getInstancia().update(elemento);
    }
    
}
