
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.model.DetalleCompra;
import java.util.List;


public interface DetalleCompraService {
    public List<DetalleCompra>findAllDetalleCompra();
    public DetalleCompra findById(Long idDetalle);
    public void saveDetalleCompra(DetalleCompra elemento);
    public void deleteDetalleCompra(DetalleCompra elemento);
    public void updateProveedor(DetalleCompra elemento);
    
}
