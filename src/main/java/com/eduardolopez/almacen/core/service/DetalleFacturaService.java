
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.model.DetalleFactura;
import java.util.List;


public interface DetalleFacturaService {
    public List<DetalleFactura> findAllDetalleFactura();
    public DetalleFactura findById(Long codigoDetalle);
    public void saveDetalleFactura(DetalleFactura elemento);
    public void deleteDetalleFactura(DetalleFactura elemento);
    public void updateDetalleFactura(DetalleFactura elemento);
    
}
