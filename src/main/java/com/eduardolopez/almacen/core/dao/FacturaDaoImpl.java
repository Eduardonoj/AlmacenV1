
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.Factura;
import java.util.List;

public class FacturaDaoImpl implements FacturaDao{

    @Override
    public List<Factura> findAllFactura() {
         return (List<Factura>) Conexion.getInstancia().findAll(Factura.class);
    }

    @Override
    public Factura findById(Long numeroFactura) {
         return (Factura) Conexion.getInstancia().findById(Factura.class, numeroFactura);
    }

    @Override
    public void saveFactura(Factura elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteFactura(Factura elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateFactura(Factura elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
