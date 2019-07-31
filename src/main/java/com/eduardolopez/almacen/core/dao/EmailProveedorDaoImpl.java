
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.EmailProveedor;
import java.util.List;


public class EmailProveedorDaoImpl implements EmailProveedorDao {

    @Override
    public List<EmailProveedor> findAllEmailProveedor() {
         return (List<EmailProveedor>) Conexion.getInstancia().findAll(EmailProveedor.class);
    }

    @Override
    public EmailProveedor findById(Long codigoEmail) {
         return (EmailProveedor) Conexion.getInstancia().findById(EmailProveedor.class, codigoEmail);
    }

    @Override
    public void saveEmailProveedor(EmailProveedor elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteEmailProveedor(EmailProveedor elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateEmailProveedor(EmailProveedor elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
