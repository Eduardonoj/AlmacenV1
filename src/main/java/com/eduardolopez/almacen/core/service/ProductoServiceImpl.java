
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.ProductoDao;
import com.eduardolopez.almacen.core.dao.ProductoDaoImpl;
import com.eduardolopez.almacen.core.model.Producto;
import java.util.List;


public class ProductoServiceImpl implements ProductoService {
    private ProductoDao productoDao = new ProductoDaoImpl();
    
    @Override
    public List<Producto> findAllProducto() {
        return productoDao.findAllProducto();
    }

    @Override
    public Producto findById(Long codigoProducto) {
        return productoDao.findById(codigoProducto);
    }

    @Override
    public void saveProducto(Producto elemento) {
        productoDao.saveProducto(elemento);
    }

    @Override
    public void deleteProducto(Producto elemento) {
        productoDao.deleteProducto(elemento);
    }

    @Override
    public void updateProducto(Producto elemento) {
        productoDao.updateProducto(elemento);
    }
    
}
