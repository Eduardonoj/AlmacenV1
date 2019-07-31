
package com.eduardolopez.almacen.core.dao;

import com.eduardolopez.almacen.core.model.Cliente;
import java.util.List;


public interface ClienteDao {
    public List<Cliente> findAllCliente();
    public Cliente findById(String nit);
    public void saveCliente(Cliente elemento);
    public void deleteCliente(Cliente elemento);
    public void updateCliente(Cliente elemento);
    
}
