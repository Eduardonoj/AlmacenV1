
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.model.Factura;
import java.util.List;


public interface FacturaDao {
    public List<Factura> findAllFactura();
    public Factura findById(Long numeroFactura);
    public void saveFactura(Factura elemento);
    public void deleteFactura(Factura elemento);
    public void updateFactura(Factura elemento);
    
    
}
