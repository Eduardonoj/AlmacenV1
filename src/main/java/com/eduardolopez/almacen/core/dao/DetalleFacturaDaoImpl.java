
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.DetalleFactura;
import java.util.List;


public class DetalleFacturaDaoImpl implements DetalleFacturaDao {

    @Override
    public List<DetalleFactura> findAllDetalleFactura() {
         return (List<DetalleFactura>) Conexion.getInstancia().findAll(DetalleFactura.class);
    }

    @Override
    public DetalleFactura findById(Long codigoDetalle) {
         return (DetalleFactura)Conexion.getInstancia().findById(DetalleFactura.class, codigoDetalle );
    }

    @Override
    public void saveDetalleFactura(DetalleFactura elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteDetalleFactura(DetalleFactura elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateDetalleFactura(DetalleFactura elemento) {
        Conexion.getInstancia().update(elemento);
    }

    
    
}
