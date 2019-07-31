
package com.eduardolopez.almacen.core.service;


import com.eduardolopez.almacen.core.dao.InventarioDao;
import com.eduardolopez.almacen.core.dao.InventarioDaoImpl;
import com.eduardolopez.almacen.core.model.Inventario;
import java.util.List;

public class InventarioServiceImpl implements InventarioService {
    private InventarioDao inventarioDao = new InventarioDaoImpl();    
    
    @Override
    public List<Inventario> findAllInventario() {
        return inventarioDao.findAllInventario();
    }

    @Override
    public Inventario findById(Long codigoInventario) {
        return inventarioDao.findById(codigoInventario);
    }

    @Override
    public void saveInventario(Inventario elemento) {
        inventarioDao.saveInventario(elemento);
    }

    @Override
    public void deleteInventario(Inventario elemento) {
        inventarioDao.deleteInventario(elemento);
    }

    @Override
    public void updateInventario(Inventario elemento) {
        inventarioDao.updateInventario(elemento);
    }
    
}
