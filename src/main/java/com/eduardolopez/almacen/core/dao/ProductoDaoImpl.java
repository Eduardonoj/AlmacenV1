
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.Producto;
import java.util.List;


public class ProductoDaoImpl implements ProductoDao {

    @Override
    public List<Producto> findAllProducto() {
         return (List<Producto>) Conexion.getInstancia().findAll(Producto.class);
    }

    @Override
    public Producto findById(Long codigoProducto) {
         return (Producto) Conexion.getInstancia().findById(Producto.class, codigoProducto);
    }

    @Override
    public void saveProducto(Producto elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteProducto(Producto elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateProducto(Producto elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
