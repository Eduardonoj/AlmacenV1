
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.model.Producto;
import java.util.List;


public interface ProductoService {
    public List<Producto> findAllProducto();
    public Producto findById(Long codigoProducto);
    public void saveProducto(Producto elemento);
    public void deleteProducto(Producto elemento);
    public void updateProducto(Producto elemento);
}
