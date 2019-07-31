
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.Compra;
import java.util.List;


public class CompraDaoImpl implements CompraDao {

    @Override
    public List<Compra> findAllCompra() {
        return (List<Compra>) Conexion.getInstancia().findAll(Compra.class);
    }

    @Override
    public Compra findById(Long idCompra) {
        return (Compra)Conexion.getInstancia().findById(Compra.class, idCompra);
    }

    @Override
    public void saveCompra(Compra elemento) {
       Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteCompra(Compra elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateCompra(Compra elemento) {
        Conexion.getInstancia().update(elemento);
    }

   
    
}
