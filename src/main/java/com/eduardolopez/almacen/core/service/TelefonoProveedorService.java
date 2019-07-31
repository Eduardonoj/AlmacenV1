
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.model.TelefonoProveedor;
import java.util.List;


public interface TelefonoProveedorService {
    public List<TelefonoProveedor> findAllTelefonoProveedor();
    public TelefonoProveedor findById(Long codigoTelefono);
    public void saveTelefonoProveedor(TelefonoProveedor elemento);
    public void deleteTelefonoProveedor(TelefonoProveedor elemento);
    public void updateTelefonoProveedor(TelefonoProveedor elemento);
}
