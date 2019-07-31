
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.Inventario;
import java.util.List;


public class InventarioDaoImpl implements InventarioDao {

    @Override
    public List<Inventario> findAllInventario() {
         return (List<Inventario>) Conexion.getInstancia().findAll(Inventario.class);
    }

    @Override
    public Inventario findById(Long codigoInventario) {
         return (Inventario) Conexion.getInstancia().findById(Inventario.class, codigoInventario);
    }

    @Override
    public void saveInventario(Inventario elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteInventario(Inventario elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateInventario(Inventario elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
