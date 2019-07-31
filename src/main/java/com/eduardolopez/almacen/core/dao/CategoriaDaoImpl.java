
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.db.Conexion;
import com.eduardolopez.almacen.core.model.Categoria;
import java.util.List;


public class CategoriaDaoImpl implements CategoriaDao {

    @Override
    public List<Categoria> findAllCategoria() {
        return (List<Categoria>) Conexion.getInstancia().findAll(Categoria.class);
    }

    @Override
    public Categoria findById(Long codigoCategoria) {
      return (Categoria)Conexion.getInstancia().findById(Categoria.class, codigoCategoria);
    }

    @Override
    public void saveCategoria(Categoria elemento) {
       Conexion.getInstancia().save(elemento);
    }

    @Override
    public void deleteCategoria(Categoria elemento) {
        Conexion.getInstancia().delete(elemento);
    }

    @Override
    public void updateCategoria(Categoria elemento) {
        Conexion.getInstancia().update(elemento);
    }
    
}
