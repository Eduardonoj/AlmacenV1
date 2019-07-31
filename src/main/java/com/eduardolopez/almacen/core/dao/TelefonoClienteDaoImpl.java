
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.TelefonoCliente;
import java.util.List;

public class TelefonoClienteDaoImpl implements TelefonoClienteDao{

    @Override
    public List<TelefonoCliente> findAllTelefonoCliente() {
         return (List<TelefonoCliente>) Conexion.getInstancia().findAll(TelefonoCliente.class);
    }

    @Override
    public TelefonoCliente findById(Long codigoTelefono) {
         return (TelefonoCliente) Conexion.getInstancia().findById(TelefonoCliente.class, codigoTelefono);
    }

    @Override
    public void saveTelefonoCliente(TelefonoCliente elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteTelefonoCliente(TelefonoCliente elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateTelefonoCliente(TelefonoCliente elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
