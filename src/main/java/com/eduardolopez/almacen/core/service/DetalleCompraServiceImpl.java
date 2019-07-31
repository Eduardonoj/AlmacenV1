
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.DetalleCompraDao;
import com.eduardolopez.almacen.core.dao.DetalleCompraDaoImpl;
import com.eduardolopez.almacen.core.model.DetalleCompra;
import java.util.List;


public class DetalleCompraServiceImpl implements DetalleCompraService {
    private DetalleCompraDao detalleCompraDao = new DetalleCompraDaoImpl(); 

    @Override
    public List<DetalleCompra> findAllDetalleCompra() {
        return detalleCompraDao.findAllDetalleCompra();
    }

    @Override
    public DetalleCompra findById(Long idDetalle) {
        return detalleCompraDao.findById(idDetalle);
    }

    @Override
    public void saveDetalleCompra(DetalleCompra elemento) {
       detalleCompraDao.saveDetalleCompra(elemento);
    }

    @Override
    public void deleteDetalleCompra(DetalleCompra elemento) {
        detalleCompraDao.deleteDetalleCompra(elemento);
    }

    @Override
    public void updateProveedor(DetalleCompra elemento) {
        detalleCompraDao.updateProveedor(elemento);
    }
    
}
