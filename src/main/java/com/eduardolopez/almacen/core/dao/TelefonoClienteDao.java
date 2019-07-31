
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.model.TelefonoCliente;
import java.util.List;


public interface TelefonoClienteDao {
    public List<TelefonoCliente> findAllTelefonoCliente();
    public TelefonoCliente findById(Long codigoTelefono);
    public void saveTelefonoCliente(TelefonoCliente elemento);
    public void deleteTelefonoCliente(TelefonoCliente elemento);
    public void updateTelefonoCliente(TelefonoCliente elemento);
    
    
}
