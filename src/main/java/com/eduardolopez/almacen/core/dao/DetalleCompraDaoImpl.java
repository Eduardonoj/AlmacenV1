
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.DetalleCompra;
import java.util.List;


public class DetalleCompraDaoImpl implements DetalleCompraDao {

    @Override
    public List<DetalleCompra> findAllDetalleCompra() {
        return (List<DetalleCompra>)Conexion.getInstancia().findAll(DetalleCompra.class);
    }

    @Override
    public DetalleCompra findById(Long idDetalle) {
        return (DetalleCompra)Conexion.getInstancia().findById(DetalleCompra.class, idDetalle);
    }

    @Override
    public void saveDetalleCompra(DetalleCompra elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteDetalleCompra(DetalleCompra elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateProveedor(DetalleCompra elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
