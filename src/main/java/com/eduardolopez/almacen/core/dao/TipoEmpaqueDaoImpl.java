
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.TipoEmpaque;
import java.util.List;


public class TipoEmpaqueDaoImpl implements TipoEmpaqueDao {

    @Override
    public List<TipoEmpaque> findAllTipoEmpaque() {
         return (List<TipoEmpaque>) Conexion.getInstancia().findAll(TipoEmpaque.class);
    }

    @Override
    public TipoEmpaque findById(Long codigoEmpaque) {
         return (TipoEmpaque) Conexion.getInstancia().findById(TipoEmpaque.class, codigoEmpaque);
    }

    @Override
    public void saveTipoEmpaque(TipoEmpaque elemento) {
        Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteTipoEmpaque(TipoEmpaque elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateProveedor(TipoEmpaque elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
