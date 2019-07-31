
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.model.DetalleFactura;
import java.util.List;


public interface DetalleFacturaDao {
    public List<DetalleFactura> findAllDetalleFactura();
    public DetalleFactura findById(Long codigoDetalle);
    public void saveDetalleFactura(DetalleFactura elemento);
    public void deleteDetalleFactura(DetalleFactura elemento);
    public void updateDetalleFactura(DetalleFactura elemento);
    
    
    
}
