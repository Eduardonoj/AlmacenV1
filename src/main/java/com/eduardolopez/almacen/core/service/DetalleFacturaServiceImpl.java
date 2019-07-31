
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.DetalleFacturaDao;
import com.eduardolopez.almacen.core.dao.DetalleFacturaDaoImpl;
import com.eduardolopez.almacen.core.model.DetalleFactura;
import java.util.List;


public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    private DetalleFacturaDao detalleFacturaDao = new DetalleFacturaDaoImpl(); 
    @Override
    public List<DetalleFactura> findAllDetalleFactura() {
        return detalleFacturaDao.findAllDetalleFactura();
    }

    @Override
    public DetalleFactura findById(Long codigoDetalle) {
        return detalleFacturaDao.findById(codigoDetalle);
    }

    @Override
    public void saveDetalleFactura(DetalleFactura elemento) {
        detalleFacturaDao.saveDetalleFactura(elemento);
    }

    @Override
    public void deleteDetalleFactura(DetalleFactura elemento) {
        detalleFacturaDao.deleteDetalleFactura(elemento);
    }

    @Override
    public void updateDetalleFactura(DetalleFactura elemento) {
        detalleFacturaDao.updateDetalleFactura(elemento);
    }
    
}
