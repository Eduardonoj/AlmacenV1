/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.CategoriaDao;
import com.eduardolopez.almacen.core.dao.CategoriaDaoImpl;
import com.eduardolopez.almacen.core.model.Categoria;
import java.util.List;

/**
 *
 * @author EDUARDO
 */
public class CategoriaServiceImpl implements CategoriaService {
    private CategoriaDao categoriaDao = new CategoriaDaoImpl();    

    @Override
    public List<Categoria> findAllCategoria() {
        return categoriaDao.findAllCategoria();
    }

    @Override
    public Categoria findById(Long codigoCategoria) {
       return categoriaDao.findById(codigoCategoria);
    }

    @Override
    public void saveCategoria(Categoria elemento) {
        categoriaDao.saveCategoria(elemento);
    }

    @Override
    public void deleteCategoria(Categoria elemento) {
        categoriaDao.deleteCategoria(elemento);
    }

    @Override
    public void updateCategoria(Categoria elemento) {
        categoriaDao.updateCategoria(elemento);
    }
}
