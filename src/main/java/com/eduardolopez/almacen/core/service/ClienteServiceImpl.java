
package com.eduardolopez.almacen.core.service;

import com.eduardolopez.almacen.core.dao.ClienteDao;
import com.eduardolopez.almacen.core.dao.ClienteDaoImpl;
import com.eduardolopez.almacen.core.model.Cliente;
import java.util.List;


public class ClienteServiceImpl implements ClienteService {
    private ClienteDao clienteDao = new ClienteDaoImpl();

    @Override
    public List<Cliente> findAllCliente() {
        return clienteDao.findAllCliente();
    }

    @Override
    public Cliente findById(String nit) {
        return clienteDao.findById(nit);
    }

    @Override
    public void saveCliente(Cliente elemento) {
        clienteDao.saveCliente(elemento);
    }

    @Override
    public void deleteCliente(Cliente elemento) {
        clienteDao.deleteCliente(elemento);
    }

    @Override
    public void updateCliente(Cliente elemento) {
        clienteDao.updateCliente(elemento);
    }
}
