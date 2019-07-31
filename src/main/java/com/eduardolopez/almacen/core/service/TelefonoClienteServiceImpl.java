
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.TelefonoClienteDao;
import com.eduardolopez.almacen.core.dao.TelefonoClienteDaoImpl;
import com.eduardolopez.almacen.core.model.TelefonoCliente;
import java.util.List;


public class TelefonoClienteServiceImpl implements TelefonoClienteService {
    private TelefonoClienteDao telefonoClienteDao = new TelefonoClienteDaoImpl();
    
    @Override
    public List<TelefonoCliente> findAllTelefonoCliente() {
        return telefonoClienteDao.findAllTelefonoCliente();
    }

    @Override
    public TelefonoCliente findById(Long codigoTelefono) {
        return telefonoClienteDao.findById(codigoTelefono);
    }

    @Override
    public void saveTelefonoCliente(TelefonoCliente elemento) {
        telefonoClienteDao.saveTelefonoCliente(elemento);
    }

    @Override
    public void deleteTelefonoCliente(TelefonoCliente elemento) {
        telefonoClienteDao.deleteTelefonoCliente(elemento);
    }

    @Override
    public void updateTelefonoCliente(TelefonoCliente elemento) {
        telefonoClienteDao.updateTelefonoCliente(elemento);
    }
    
}
