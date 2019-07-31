
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.model.TipoEmpaque;
import java.util.List;


public interface TipoEmpaqueService {
    public List<TipoEmpaque> findAllTipoEmpaque();
    public TipoEmpaque findById(Long codigoEmpaque);
    public void saveTipoEmpaque(TipoEmpaque elemento);
    public void deleteTipoEmpaque(TipoEmpaque elemento);
    public void updateProveedor (TipoEmpaque elemento);
}
