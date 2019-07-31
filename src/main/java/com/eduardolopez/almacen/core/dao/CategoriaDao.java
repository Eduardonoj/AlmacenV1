
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.model.Categoria;
import java.util.List;


public interface CategoriaDao {
    public List<Categoria> findAllCategoria();
    public Categoria findById(Long codigoCategoria);
    public void saveCategoria(Categoria elemento);
    public void deleteCategoria(Categoria elemento);
    public void updateCategoria(Categoria elemento);
    
}
