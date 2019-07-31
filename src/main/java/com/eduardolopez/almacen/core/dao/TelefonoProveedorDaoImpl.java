
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.TelefonoProveedor;
import java.util.List;


public class TelefonoProveedorDaoImpl implements TelefonoProveedorDao{

    @Override
    public List<TelefonoProveedor> findAllTelefonoProveedor() {
         return (List<TelefonoProveedor>) Conexion.getInstancia().findAll(TelefonoProveedor.class);
    }

    @Override
    public TelefonoProveedor findById(Long codigoTelefono) {
         return (TelefonoProveedor) Conexion.getInstancia().findById(TelefonoProveedor.class, codigoTelefono);
    }

    @Override
    public void saveTelefonoProveedor(TelefonoProveedor elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteTelefonoProveedor(TelefonoProveedor elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateTelefonoProveedor(TelefonoProveedor elemento) {
       Conexion.getInstancia().update(elemento);
    }
    
}
