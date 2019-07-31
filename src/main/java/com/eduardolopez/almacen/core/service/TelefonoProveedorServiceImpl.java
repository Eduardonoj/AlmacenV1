
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.TelefonoProveedorDao;
import com.eduardolopez.almacen.core.dao.TelefonoProveedorDaoImpl;
import com.eduardolopez.almacen.core.model.TelefonoProveedor;
import java.util.List;


public class TelefonoProveedorServiceImpl implements TelefonoProveedorService {
    private TelefonoProveedorDao telefonoProveedorDao = new TelefonoProveedorDaoImpl();
    
    @Override
    public List<TelefonoProveedor> findAllTelefonoProveedor() {
        return telefonoProveedorDao.findAllTelefonoProveedor();
    }

    @Override
    public TelefonoProveedor findById(Long codigoTelefono) {
        return telefonoProveedorDao.findById(codigoTelefono);
    }

    @Override
    public void saveTelefonoProveedor(TelefonoProveedor elemento) {
       telefonoProveedorDao.saveTelefonoProveedor(elemento);
    }

    @Override
    public void deleteTelefonoProveedor(TelefonoProveedor elemento) {
        telefonoProveedorDao.deleteTelefonoProveedor(elemento);
    }

    @Override
    public void updateTelefonoProveedor(TelefonoProveedor elemento) {
        telefonoProveedorDao.updateTelefonoProveedor(elemento);
    }
    
}
