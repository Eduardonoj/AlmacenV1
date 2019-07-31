
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.TipoEmpaqueDao;
import com.eduardolopez.almacen.core.dao.TipoEmpaqueDaoImpl;
import com.eduardolopez.almacen.core.model.TipoEmpaque;
import java.util.List;


public class TipoEmpaqueServiceImpl implements TipoEmpaqueService{
    private TipoEmpaqueDao tipoEmpaqueDao = new TipoEmpaqueDaoImpl();    
        
    @Override
    public List<TipoEmpaque> findAllTipoEmpaque() {
        return tipoEmpaqueDao.findAllTipoEmpaque();
    }

    @Override
    public TipoEmpaque findById(Long codigoEmpaque) {
        return tipoEmpaqueDao.findById(codigoEmpaque);
    }

    @Override
    public void saveTipoEmpaque(TipoEmpaque elemento) {
        tipoEmpaqueDao.saveTipoEmpaque(elemento);
    }

    @Override
    public void deleteTipoEmpaque(TipoEmpaque elemento) {
       tipoEmpaqueDao.deleteTipoEmpaque(elemento);
    }

    @Override
    public void updateProveedor(TipoEmpaque elemento) {
        tipoEmpaqueDao.updateProveedor(elemento);
    }
    
}
