
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.model.Inventario;
import java.util.List;

public interface InventarioDao {
    public List<Inventario> findAllInventario();
    public Inventario findById(Long codigoInventario);
    public void saveInventario(Inventario elemento);
    public void deleteInventario(Inventario elemento);
    public void updateInventario(Inventario elemento);
    
    
}
